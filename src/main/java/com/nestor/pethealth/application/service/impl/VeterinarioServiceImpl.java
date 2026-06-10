package com.nestor.pethealth.application.service.impl;

import com.nestor.pethealth.application.dto.VeterinarioDTO;
import com.nestor.pethealth.application.service.VeterinarioService;
import com.nestor.pethealth.domain.model.Persona;
import com.nestor.pethealth.domain.model.TipoPersona;
import com.nestor.pethealth.domain.model.Veterinario;
import com.nestor.pethealth.domain.repository.PersonaRepository;
import com.nestor.pethealth.domain.repository.VeterinarioRepository;
import com.nestor.pethealth.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;
    private final PersonaRepository personaRepository;

    @Override
    public VeterinarioDTO crear(VeterinarioDTO dto) {
        Persona persona = personaRepository.findById(dto.getIdPersona())
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada: " + dto.getIdPersona()));

        persona.setTipoPersona(TipoPersona.VETERINARIO);
        personaRepository.save(persona);

        Veterinario veterinario = Veterinario.builder()
                .persona(persona)
                .especialidad(dto.getEspecialidad())
                .numeroLicencia(dto.getNumeroLicencia())
                .build();

        veterinario = veterinarioRepository.save(veterinario);
        return toDTO(veterinario);
    }

    @Override
    public VeterinarioDTO obtenerPorId(Long id) {
        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado: " + id));
        return toDTO(veterinario);
    }

    @Override
    public List<VeterinarioDTO> listar() {
        return veterinarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public VeterinarioDTO actualizar(Long id, VeterinarioDTO dto) {
        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado: " + id));

        veterinario.setEspecialidad(dto.getEspecialidad());
        veterinario.setNumeroLicencia(dto.getNumeroLicencia());

        veterinario = veterinarioRepository.save(veterinario);
        return toDTO(veterinario);
    }

    @Override
    public void eliminar(Long id) {
        Veterinario veterinario = veterinarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado: " + id));

        Persona persona = veterinario.getPersona();
        persona.setTipoPersona(null);
        personaRepository.save(persona);

        veterinarioRepository.delete(veterinario);
    }

    private VeterinarioDTO toDTO(Veterinario veterinario) {
        return VeterinarioDTO.builder()
                .idPersona(veterinario.getPersona().getId())
                .especialidad(veterinario.getEspecialidad())
                .numeroLicencia(veterinario.getNumeroLicencia())
                .build();
    }
}
