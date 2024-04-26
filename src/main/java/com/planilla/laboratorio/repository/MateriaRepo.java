package com.planilla.laboratorio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planilla.laboratorio.model.Materia;

@Repository
public interface MateriaRepo extends JpaRepository<Materia, Long> {
    public Optional<Materia> findById(Long id);

    public List<Materia> findByNombre(String nombre);

    public List<Materia> findByNombreContainingIgnoreCaseOrderByNombreAsc(String nombre);

    public List<Materia> findByNombreContainingIgnoreCaseOrderByNombreDesc(String nombre);

    public void deleteById(Long id);
}
