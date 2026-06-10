package com.nestor.pethealth.application.service;

import com.nestor.pethealth.application.dto.ConsultaMedicaDTO;
import java.util.List;

public interface ConsultaMedicaService {

    ConsultaMedicaDTO crear(ConsultaMedicaDTO dto);

    ConsultaMedicaDTO obtenerPorId(Long id);

    List<ConsultaMedicaDTO> listar();

    ConsultaMedicaDTO actualizar(Long id, ConsultaMedicaDTO dto);

    void eliminar(Long id);
}
