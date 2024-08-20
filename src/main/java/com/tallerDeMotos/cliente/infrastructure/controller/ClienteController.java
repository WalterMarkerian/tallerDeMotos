package com.tallerDeMotos.cliente.infrastructure.controller;

import com.tallerDeMotos.cliente.application.create.ClienteCreator;
import com.tallerDeMotos.cliente.application.delete.ClienteDeleterByDni;
import com.tallerDeMotos.cliente.application.find_all.ClienteFindAll;
import com.tallerDeMotos.cliente.application.find_by_dni.ClienteFindByDni;
import com.tallerDeMotos.cliente.application.update_by_dni.ClienteUpdateByDni;
import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.domain.exception.ClientesNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaDuplicatePatenteException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteCreator clienteCreator;
    @Autowired
    private ClienteDeleterByDni clienteDeleteByDni;
    @Autowired
    private ClienteFindByDni clienteFindByDni;
    @Autowired
    private ClienteFindAll clienteFindAll;
    @Autowired
    private ClienteUpdateByDni clienteUpdateByDni;

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody ClienteDTO clienteCreateDTO) throws
            ClienteDuplicateDniException, MotocicletaDuplicatePatenteException, ClienteNotFoundException {
        ClienteDTO clienteDTO = clienteCreator.createCliente(clienteCreateDTO);
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<ClienteDTO> getClienteByDni(@PathVariable Long dni) throws ClienteNotFoundException {
        ClienteDTO clienteDTO = clienteFindByDni.getClienteByDni(dni);
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() throws ClientesNotFoundException {
        List<ClienteDTO> clientes = clienteFindAll.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{dni}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long dni,
                                                    @Valid @RequestBody ClienteDTO clienteDTO) throws ClienteNotFoundException {
        ClienteDTO clienteUpdatedDTO = clienteUpdateByDni.updateClienteByDni(dni, clienteDTO);
        return ResponseEntity.ok(clienteDTO);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long dni) throws ClienteNotFoundException {
        clienteDeleteByDni.deleteClienteByDni(dni);
        return ResponseEntity.accepted().build();
    }
}
