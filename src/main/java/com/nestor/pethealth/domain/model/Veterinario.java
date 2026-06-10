package com.nestor.pethealth.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "veterinarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veterinario {

    @Id
    private Long id; // mismo ID que Persona

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Persona persona;

    private String especialidad;

    @Column(name = "numero_licencia", unique = true)
    private String numeroLicencia;
}
