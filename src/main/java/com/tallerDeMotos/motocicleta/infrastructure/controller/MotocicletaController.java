package com.tallerDeMotos.motocicleta.infrastructure.controller;

import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.motocicleta.application.create.MotocicletaCreator;
import com.tallerDeMotos.motocicleta.application.delete.MotocicletaDeleterByPatente;
import com.tallerDeMotos.motocicleta.application.find_all.MotocicletaFindAll;
import com.tallerDeMotos.motocicleta.application.find_by_patente.MotocicletaFindByPatente;
import com.tallerDeMotos.motocicleta.application.update_by_patente.MotocicletaUpdateByPatente;
import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaDuplicatePatenteException;
import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallerDeMotos.motocicleta.domain.exception.MotocicletasNotFoundException;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motocicletas")
public class MotocicletaController {
    @Autowired
    private MotocicletaCreator motocicletaCreator;
    @Autowired
    private MotocicletaDeleterByPatente motocicletaDeleterByPatente;
    @Autowired
    private MotocicletaFindByPatente motocicletaFindByPatente;
    @Autowired
    private MotocicletaFindAll motocicletaFindAll;
    @Autowired
    private MotocicletaUpdateByPatente motocicletaUpdateByPatente;

    @PostMapping
    public ResponseEntity<MotocicletaDTO> createMotocicleta(@Valid @RequestBody MotocicletaDTO motocicletaDTO) throws
            MotocicletaDuplicatePatenteException, ClienteNotFoundException {
        MotocicletaDTO createdMotocicletaDTO = motocicletaCreator.createMoto(motocicletaDTO);
        return ResponseEntity.ok(createdMotocicletaDTO);
    }

    @GetMapping("/{patente}")
    public ResponseEntity<MotocicletaDTO> getMotocicletaByPatente(@PathVariable String patente) throws MotocicletaPatenteNotFoundException {
        MotocicletaDTO motocicletaDTO = motocicletaFindByPatente.getMotocicletaByPatente(patente);
        return ResponseEntity.ok(motocicletaDTO);
    }

    @GetMapping
    public ResponseEntity<List<MotocicletaDTO>> getAllMotocicletas() throws MotocicletasNotFoundException {
        List<MotocicletaDTO> motocicletas = motocicletaFindAll.getAllMotocicletas();
        return ResponseEntity.ok(motocicletas);
    }

    @PutMapping("/{patente}")
    public ResponseEntity<MotocicletaDTO> updateMotocicleta(@PathVariable String patente, @Valid @RequestBody MotocicletaDTO motocicletaDTO)
            throws MotocicletaPatenteNotFoundException {
        MotocicletaDTO updatedMotocicletaDTO = motocicletaUpdateByPatente.updateMotocicletaByPatente(patente, motocicletaDTO);
        return ResponseEntity.ok(updatedMotocicletaDTO);
    }

    @DeleteMapping("/{patente}")
    public ResponseEntity<Void> deleteMotocicleta(@PathVariable String patente) throws MotocicletaPatenteNotFoundException {
        motocicletaDeleterByPatente.deleteByPatente(patente);
        return ResponseEntity.accepted().build();
    }
}
