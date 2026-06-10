package com.nestor.pethealth.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarioDTO {

    private Long idPersona;      // FK a Persona
    private String especialidad;
    private String numeroLicencia;
}
