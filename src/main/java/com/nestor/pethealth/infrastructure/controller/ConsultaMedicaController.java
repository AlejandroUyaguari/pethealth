package com.nestor.pethealth.infrastructure.controller;

import com.nestor.pethealth.application.dto.ConsultaMedicaDTO;
import com.nestor.pethealth.application.service.ConsultaMedicaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaMedicaController {

    private final ConsultaMedicaService service;

    public ConsultaMedicaController(ConsultaMedicaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ConsultaMedicaDTO> crear(@Valid @RequestBody ConsultaMedicaDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaMedicaDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaMedicaDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaMedicaDTO> actualizar(@PathVariable Long id,
                                                        @Valid @RequestBody ConsultaMedicaDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
