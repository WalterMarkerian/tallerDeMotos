package com.tallerDeMotos.ordenDeTrabajo.application.create;

import com.tallerDeMotos.motocicleta.domain.exception.MotocicletaDuplicatePatenteException;
import com.tallerDeMotos.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallerDeMotos.ordenDeTrabajo.domain.exception.OrdenDeTrabajoDuplicateIdException;
import com.tallerDeMotos.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;

public interface OrdenDeTrabajoCreater {

    OrdenDeTrabajoDTO createOrdenDeTrabajo(OrdenDeTrabajoDTO ordenDeTrabajoDTO) throws OrdenDeTrabajoDuplicateIdException;


}
