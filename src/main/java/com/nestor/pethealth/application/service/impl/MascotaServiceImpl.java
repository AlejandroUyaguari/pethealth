package com.nestor.pethealth.application.service.impl;

import com.nestor.pethealth.application.dto.MascotaDTO;
import com.nestor.pethealth.application.service.MascotaService;
import com.nestor.pethealth.domain.model.Mascota;
import com.nestor.pethealth.domain.model.Persona;
import com.nestor.pethealth.domain.repository.MascotaRepository;
import com.nestor.pethealth.domain.repository.PersonaRepository;
import com.nestor.pethealth.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final PersonaRepository personaRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository,
                              PersonaRepository personaRepository) {
        this.mascotaRepository = mascotaRepository;
        this.personaRepository = personaRepository;
    }

    @Override
    public MascotaDTO crear(MascotaDTO dto) {
        Persona persona = personaRepository.findById(dto.getPersonaId())
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada: " + dto.getPersonaId()));

        Mascota mascota = toEntity(dto);
        mascota.setPersona(persona);

        return toDTO(mascotaRepository.save(mascota));
    }

    @Override
    public MascotaDTO obtenerPorId(Long id) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada: " + id));
        return toDTO(mascota);
    }

    @Override
    public List<MascotaDTO> listar() {
        return mascotaRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public MascotaDTO actualizar(Long id, MascotaDTO dto) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada: " + id));

        Persona persona = personaRepository.findById(dto.getPersonaId())
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada: " + dto.getPersonaId()));

        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setRaza(dto.getRaza());
        mascota.setFechaNacimiento(dto.getFechaNacimiento());
        mascota.setPersona(persona);

        return toDTO(mascotaRepository.save(mascota));
    }

    @Override
    public void eliminar(Long id) {
        mascotaRepository.deleteById(id);
    }

    private Mascota toEntity(MascotaDTO dto) {
        return Mascota.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .especie(dto.getEspecie())
                .raza(dto.getRaza())
                .fechaNacimiento(dto.getFechaNacimiento())
                .build();
    }

    private MascotaDTO toDTO(Mascota mascota) {
        return MascotaDTO.builder()
                .id(mascota.getId())
                .nombre(mascota.getNombre())
                .especie(mascota.getEspecie())
                .raza(mascota.getRaza())
                .fechaNacimiento(mascota.getFechaNacimiento())
                .personaId(mascota.getPersona().getId())
                .build();
    }
}
