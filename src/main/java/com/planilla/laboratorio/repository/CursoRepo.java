package com.planilla.laboratorio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planilla.laboratorio.model.Curso;

@Repository
public interface CursoRepo extends JpaRepository<Curso, Long> {
    public List<Curso> findAllByOrderByNombreAsc();

    public Optional<Curso> findById(Long id);

    public Optional<Curso> findByNombre(String nombre);

    public List<Curso> findByNombreContainingIgnoreCaseOrderByNombreAsc(String nombre);

    public List<Curso> findByNombreContainingIgnoreCaseOrderByNombreDesc(String nombre);

    public void deleteById(Long id);
}
