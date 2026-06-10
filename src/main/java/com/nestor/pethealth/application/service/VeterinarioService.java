package com.nestor.pethealth.application.service;

import com.nestor.pethealth.application.dto.VeterinarioDTO;

import java.util.List;

public interface VeterinarioService {

    VeterinarioDTO crear(VeterinarioDTO dto);

    VeterinarioDTO obtenerPorId(Long id);

    List<VeterinarioDTO> listar();

    VeterinarioDTO actualizar(Long id, VeterinarioDTO dto);

    void eliminar(Long id);
}
