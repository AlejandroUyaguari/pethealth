package com.nestor.pethealth.application.service;

import com.nestor.pethealth.application.dto.PersonaDTO;
import java.util.List;

public interface PersonaService {

    PersonaDTO crear(PersonaDTO dto);

    PersonaDTO obtenerPorId(Long id);

    List<PersonaDTO> listar();

    PersonaDTO actualizar(Long id, PersonaDTO dto);

    void eliminar(Long id);
}
