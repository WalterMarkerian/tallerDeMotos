package com.tallerDeMotos.ordenDeTrabajo.infrastructure.controller;

import com.tallerDeMotos.ordenDeTrabajo.application.create.OrdenDeTrabajoCreater;
import com.tallerDeMotos.ordenDeTrabajo.application.delete.OrdenDeTrabajoDeleter;
import com.tallerDeMotos.ordenDeTrabajo.application.find_all.OrdenDeTrabajoFindAll;
import com.tallerDeMotos.ordenDeTrabajo.application.find_by_id.OrdenDeTrabajoFindById;
import com.tallerDeMotos.ordenDeTrabajo.application.update.OrdenDeTrabajoUpdater;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoDuplicateIdException;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes-de-trabajo")
public class OrdenDeTrabajoController {

    private final OrdenDeTrabajoCreater ordenDeTrabajoCreater;
    private final OrdenDeTrabajoDeleter ordenDeTrabajoDeleter;
    private final OrdenDeTrabajoFindById ordenDeTrabajoFindById;
    private final OrdenDeTrabajoFindAll ordenDeTrabajoFindAll;
    private final OrdenDeTrabajoUpdater ordenDeTrabajoUpdater;

    public OrdenDeTrabajoController(OrdenDeTrabajoCreater ordenDeTrabajoCreater, OrdenDeTrabajoDeleter ordenDeTrabajoDeleter, OrdenDeTrabajoFindById ordenDeTrabajoFindById, OrdenDeTrabajoFindAll ordenDeTrabajoFindAll, OrdenDeTrabajoUpdater ordenDeTrabajoUpdater) {
        this.ordenDeTrabajoCreater = ordenDeTrabajoCreater;
        this.ordenDeTrabajoDeleter = ordenDeTrabajoDeleter;
        this.ordenDeTrabajoFindById = ordenDeTrabajoFindById;
        this.ordenDeTrabajoFindAll = ordenDeTrabajoFindAll;
        this.ordenDeTrabajoUpdater = ordenDeTrabajoUpdater;
    }


    @PostMapping
    public ResponseEntity<OrdenDeTrabajoDTO> createOrdenDeTrabajo(@Valid @RequestBody OrdenDeTrabajoDTO ordenDeTrabajoDTO) throws OrdenDeTrabajoDuplicateIdException {
        OrdenDeTrabajoDTO createdDTO = ordenDeTrabajoCreater.createOrdenDeTrabajo(ordenDeTrabajoDTO);
        return ResponseEntity.ok(createdDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenDeTrabajoDTO> getOrdenDeTrabajoById(@PathVariable Long id) throws OrdenDeTrabajoNotFoundException {
        OrdenDeTrabajoDTO ordenDeTrabajoDTO = ordenDeTrabajoFindById.getOrdenDeTrabajoById(id);
        return ResponseEntity.ok(ordenDeTrabajoDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrdenDeTrabajoDTO>> getAllOrdenesDeTrabajo() throws OrdenDeTrabajoNotFoundException {
        List<OrdenDeTrabajoDTO> ordenes = ordenDeTrabajoFindAll.getAllOrdenesDeTrabajo();
        return ResponseEntity.ok(ordenes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenDeTrabajoDTO> updateOrdenDeTrabajo(@PathVariable Long id,
                                                                  @Valid @RequestBody OrdenDeTrabajoDTO ordenDeTrabajoDTO) throws OrdenDeTrabajoNotFoundException {
        OrdenDeTrabajoDTO updatedDTO = ordenDeTrabajoUpdater.updateOrdenDeTrabajoById(id, ordenDeTrabajoDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdenDeTrabajo(@PathVariable Long id) throws OrdenDeTrabajoNotFoundException {
        ordenDeTrabajoDeleter.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
