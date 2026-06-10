package com.nestor.pethealth.application.service;

import com.nestor.pethealth.application.dto.MascotaDTO;
import java.util.List;

public interface MascotaService {

    MascotaDTO crear(MascotaDTO dto);

    MascotaDTO obtenerPorId(Long id);

    List<MascotaDTO> listar();

    MascotaDTO actualizar(Long id, MascotaDTO dto);

    void eliminar(Long id);
}
