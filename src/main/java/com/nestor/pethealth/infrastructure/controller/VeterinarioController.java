package com.nestor.pethealth.infrastructure.controller;

import com.nestor.pethealth.application.dto.VeterinarioDTO;
import com.nestor.pethealth.application.service.VeterinarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
@RequiredArgsConstructor
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    @PostMapping
    public ResponseEntity<VeterinarioDTO> crear(@RequestBody VeterinarioDTO dto) {
        return ResponseEntity.ok(veterinarioService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(veterinarioService.obtenerPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<VeterinarioDTO>> listar() {
        return ResponseEntity.ok(veterinarioService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeterinarioDTO> actualizar(@PathVariable Long id,
                                                     @RequestBody VeterinarioDTO dto) {
        return ResponseEntity.ok(veterinarioService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        veterinarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
