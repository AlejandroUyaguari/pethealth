package com.nestor.pethealth.application.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ConsultaMedicaDTO {

    private Long id;

    @NotNull
    private LocalDateTime fecha;

    @NotBlank
    private String motivo;

    private String diagnostico;

    @NotNull
    private Double costo;

    @NotNull
    private Long mascotaId;

    @NotNull
    private Long veterinarioId;
}
