package com.tallerDeMotos.cliente.infrastructure.controller;

import com.tallerDeMotos.cliente.application.create.ClienteCreator;
import com.tallerDeMotos.cliente.application.delete.ClienteDeleterByDni;
import com.tallerDeMotos.cliente.application.find_all.ClienteFindAll;
import com.tallerDeMotos.cliente.application.find_by_dni.ClienteFindByDni;
import com.tallerDeMotos.cliente.application.update.ClienteUpdateByDni;
import com.tallerDeMotos.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallerDeMotos.cliente.domain.exception.ClienteNotFoundException;
import com.tallerDeMotos.cliente.domain.exception.ClientesNotFoundException;
import com.tallerDeMotos.cliente.infrastructure.model.dto.ClienteDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteCreator clienteCreator;
    private final ClienteDeleterByDni clienteDeleteByDni;
    private final ClienteFindByDni clienteFindByDni;
    private final ClienteFindAll clienteFindAll;
    private final ClienteUpdateByDni clienteUpdateByDni;

    public ClienteController(ClienteCreator clienteCreator, ClienteDeleterByDni clienteDeleteByDni, ClienteFindByDni clienteFindByDni, ClienteFindAll clienteFindAll, ClienteUpdateByDni clienteUpdateByDni) {
        this.clienteCreator = clienteCreator;
        this.clienteDeleteByDni = clienteDeleteByDni;
        this.clienteFindByDni = clienteFindByDni;
        this.clienteFindAll = clienteFindAll;
        this.clienteUpdateByDni = clienteUpdateByDni;
    }


    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody ClienteDTO clienteCreateDTO) throws ClienteDuplicateDniException {
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
