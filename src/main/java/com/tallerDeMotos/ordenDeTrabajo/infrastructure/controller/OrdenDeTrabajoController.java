package com.tallerDeMotos.ordenDeTrabajo.infrastructure.controller;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletasNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.application.create.OrdenDeTrabajoCreater;
import com.tallerDeMotos.ordenDeTrabajo.application.delete.OrdenDeTrabajoDeleter;
import com.tallerDeMotos.ordenDeTrabajo.application.find_all.OrdenDeTrabajoFindAll;
import com.tallerDeMotos.ordenDeTrabajo.application.find_by_id.OrdenDeTrabajoFindById;
import com.tallerDeMotos.ordenDeTrabajo.application.update.OrdenDeTrabajoUpdater;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoDuplicateIdException;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoNotFoundException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes-de-trabajo")
public class OrdenDeTrabajoController {
    @Autowired
    private OrdenDeTrabajoCreater ordenDeTrabajoCreater;
    @Autowired
    private OrdenDeTrabajoDeleter ordenDeTrabajoDeleter;
    @Autowired
    private OrdenDeTrabajoFindById ordenDeTrabajoFindById;
    @Autowired
    private OrdenDeTrabajoFindAll ordenDeTrabajoFindAll;
    @Autowired
    private OrdenDeTrabajoUpdater ordenDeTrabajoUpdater;

    @PostMapping
    public ResponseEntity<OrdenDeTrabajoDTO> createOrdenDeTrabajo(@Valid @RequestBody OrdenDeTrabajoDTO ordenDeTrabajoDTO) throws OrdenDeTrabajoDuplicateIdException, MotocicletasNotFoundException {
        OrdenDeTrabajoDTO createdDTO = ordenDeTrabajoCreater.createOrdenDeTrabajo(ordenDeTrabajoDTO);
        return ResponseEntity.ok(createdDTO);
    }

    @GetMapping("/{ordenDeTrabajoId}")
    public ResponseEntity<OrdenDeTrabajoDTO> getOrdenDeTrabajoById(@PathVariable Long ordenDeTrabajoId) throws OrdenDeTrabajoNotFoundException {
        OrdenDeTrabajoDTO ordenDeTrabajoDTO = ordenDeTrabajoFindById.getOrdenDeTrabajoByOrdenDeTrabajoId(ordenDeTrabajoId);
        return ResponseEntity.ok(ordenDeTrabajoDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrdenDeTrabajoDTO>> getAllOrdenesDeTrabajo() throws OrdenDeTrabajoNotFoundException {
        List<OrdenDeTrabajoDTO> ordenes = ordenDeTrabajoFindAll.getAllOrdenesDeTrabajo();
        return ResponseEntity.ok(ordenes);
    }

    @PutMapping("/{ordenDeTrabajoId}")
    public ResponseEntity<OrdenDeTrabajoDTO> updateOrdenDeTrabajo(@PathVariable Long ordenDeTrabajoId,
                                                                  @Valid @RequestBody OrdenDeTrabajoDTO ordenDeTrabajoDTO) throws OrdenDeTrabajoNotFoundException {
        OrdenDeTrabajoDTO updatedDTO = ordenDeTrabajoUpdater.updateOrdenDeTrabajoById(ordenDeTrabajoId, ordenDeTrabajoDTO);
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{ordenDeTrabajoId}")
    public ResponseEntity<Long> deleteOrdenDeTrabajo(@PathVariable Long ordenDeTrabajoId) throws OrdenDeTrabajoNotFoundException {
        ordenDeTrabajoDeleter.deleteByOrdenDeTrabajoId(ordenDeTrabajoId);
        return ResponseEntity.accepted().body(ordenDeTrabajoId);
    }
}
