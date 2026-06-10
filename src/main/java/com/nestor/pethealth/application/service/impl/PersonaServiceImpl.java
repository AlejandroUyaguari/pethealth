package com.nestor.pethealth.application.service.impl;

import com.nestor.pethealth.application.dto.PersonaDTO;
import com.nestor.pethealth.application.service.PersonaService;
import com.nestor.pethealth.domain.model.Persona;
import com.nestor.pethealth.domain.repository.PersonaRepository;
import com.nestor.pethealth.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository repository;

    public PersonaServiceImpl(PersonaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonaDTO crear(PersonaDTO dto) {
        Persona persona = toEntity(dto);
        return toDTO(repository.save(persona));
    }

    @Override
    public PersonaDTO obtenerPorId(Long id) {
        Persona persona = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada: " + id));
        return toDTO(persona);
    }

    @Override
    public List<PersonaDTO> listar() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public PersonaDTO actualizar(Long id, PersonaDTO dto) {
        Persona persona = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada: " + id));

        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setCedula(dto.getCedula());
        persona.setTelefono(dto.getTelefono());
        persona.setEmail(dto.getEmail());

        return toDTO(repository.save(persona));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    private Persona toEntity(PersonaDTO dto) {
        return Persona.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .cedula(dto.getCedula())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .build();
    }

    private PersonaDTO toDTO(Persona persona) {
        return PersonaDTO.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .cedula(persona.getCedula())
                .telefono(persona.getTelefono())
                .email(persona.getEmail())
                .build();
    }
}
