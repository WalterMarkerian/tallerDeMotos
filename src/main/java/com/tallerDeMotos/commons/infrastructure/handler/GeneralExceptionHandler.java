package com.tallerDeMotos.commons.infrastructure.handler;

import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.commons.domain.BaseException;
import com.tallerDeMotos.commons.mapper.ApiErrorMapper;
import com.tallerDeMotos.commons.model.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GeneralExceptionHandler {

    private final ApiErrorMapper errorMapper;

    private ApiError buildGeneralResponse(BaseException e, HttpServletRequest request) {
        String exceptionName = e.getClass().getSimpleName();
        String completePath = request.getMethod().concat(":").concat(request.getRequestURI());
        log.error("Unable to run the requested operation" + completePath); //,e);
        return errorMapper.toApiError(exceptionName, e, completePath);
    }

    @ExceptionHandler(ClienteDuplicateDniException.class)
    public ResponseEntity<Object> handleClienteDuplicateDniException(ClienteDuplicateDniException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildGeneralResponse(e, request));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception e, HttpServletRequest request) {
        // Handle other exceptions not specifically handled
        BaseException baseException = new BaseException("Unknown error occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(buildGeneralResponse(baseException, request));
    }
}
