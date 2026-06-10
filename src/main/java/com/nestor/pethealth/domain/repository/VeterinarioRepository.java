package com.nestor.pethealth.domain.repository;

import com.nestor.pethealth.domain.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
