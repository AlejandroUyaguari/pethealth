package com.nestor.pethealth.application.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MascotaDTO {

    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String especie;

    @NotBlank
    private String raza;

    @NotNull
    private LocalDate fechaNacimiento;

    @NotNull
    private Long personaId;
}
