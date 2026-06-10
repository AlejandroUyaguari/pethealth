package com.nestor.pethealth.application.service.impl;

import com.nestor.pethealth.application.dto.ConsultaMedicaDTO;
import com.nestor.pethealth.application.service.ConsultaMedicaService;
import com.nestor.pethealth.domain.model.ConsultaMedica;
import com.nestor.pethealth.domain.model.Mascota;
import com.nestor.pethealth.domain.model.Veterinario;
import com.nestor.pethealth.domain.repository.ConsultaMedicaRepository;
import com.nestor.pethealth.domain.repository.MascotaRepository;
import com.nestor.pethealth.domain.repository.VeterinarioRepository;
import com.nestor.pethealth.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaMedicaServiceImpl implements ConsultaMedicaService {

    private final ConsultaMedicaRepository consultaRepository;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

    public ConsultaMedicaServiceImpl(
            ConsultaMedicaRepository consultaRepository,
            MascotaRepository mascotaRepository,
            VeterinarioRepository veterinarioRepository) {
        this.consultaRepository = consultaRepository;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    @Override
    public ConsultaMedicaDTO crear(ConsultaMedicaDTO dto) {
        Mascota mascota = mascotaRepository.findById(dto.getMascotaId())
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada: " + dto.getMascotaId()));

        Veterinario veterinario = veterinarioRepository.findById(dto.getVeterinarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado: " + dto.getVeterinarioId()));

        ConsultaMedica consulta = toEntity(dto);
        consulta.setMascota(mascota);
        consulta.setVeterinario(veterinario);

        return toDTO(consultaRepository.save(consulta));
    }

    @Override
    public ConsultaMedicaDTO obtenerPorId(Long id) {
        ConsultaMedica consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta no encontrada: " + id));
        return toDTO(consulta);
    }

    @Override
    public List<ConsultaMedicaDTO> listar() {
        return consultaRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public ConsultaMedicaDTO actualizar(Long id, ConsultaMedicaDTO dto) {
        ConsultaMedica consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta no encontrada: " + id));

        Mascota mascota = mascotaRepository.findById(dto.getMascotaId())
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada: " + dto.getMascotaId()));

        Veterinario veterinario = veterinarioRepository.findById(dto.getVeterinarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado: " + dto.getVeterinarioId()));

        consulta.setFecha(dto.getFecha());
        consulta.setMotivo(dto.getMotivo());
        consulta.setDiagnostico(dto.getDiagnostico());
        consulta.setCosto(dto.getCosto());
        consulta.setMascota(mascota);
        consulta.setVeterinario(veterinario);

        return toDTO(consultaRepository.save(consulta));
    }

    @Override
    public void eliminar(Long id) {
        consultaRepository.deleteById(id);
    }

    private ConsultaMedica toEntity(ConsultaMedicaDTO dto) {
        return ConsultaMedica.builder()
                .id(dto.getId())
                .fecha(dto.getFecha())
                .motivo(dto.getMotivo())
                .diagnostico(dto.getDiagnostico())
                .costo(dto.getCosto())
                .build();
    }

    private ConsultaMedicaDTO toDTO(ConsultaMedica consulta) {
        return ConsultaMedicaDTO.builder()
                .id(consulta.getId())
                .fecha(consulta.getFecha())
                .motivo(consulta.getMotivo())
                .diagnostico(consulta.getDiagnostico())
                .costo(consulta.getCosto())
                .mascotaId(consulta.getMascota().getId())
                .veterinarioId(consulta.getVeterinario().getId())
                .build();
    }
}
