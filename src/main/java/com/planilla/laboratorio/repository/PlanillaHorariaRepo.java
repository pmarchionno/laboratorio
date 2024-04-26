package com.planilla.laboratorio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planilla.laboratorio.model.PlanillaHoraria;

@Repository
public interface PlanillaHorariaRepo extends JpaRepository<PlanillaHoraria, Long>{
    public Optional<PlanillaHoraria> findById(Long id);
    public List<PlanillaHoraria> findByDia(String nombre);
    public void deleteById(Long id);
}
