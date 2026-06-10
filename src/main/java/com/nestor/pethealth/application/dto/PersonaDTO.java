package com.nestor.pethealth.application.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class PersonaDTO {

    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String cedula;

    @NotBlank
    private String telefono;

    @Email
    @NotBlank
    private String email;
}
