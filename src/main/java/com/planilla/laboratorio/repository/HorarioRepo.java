package com.planilla.laboratorio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planilla.laboratorio.model.Horario;

@Repository
public interface HorarioRepo extends JpaRepository<Horario, Long> {
    public Optional<Horario> findById(Long id);

    public void deleteById(Long id);
}