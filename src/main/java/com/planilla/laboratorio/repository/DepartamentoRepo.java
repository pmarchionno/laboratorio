package com.planilla.laboratorio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planilla.laboratorio.model.Departamento;

@Repository
public interface DepartamentoRepo extends JpaRepository<Departamento, Long> {
    public Optional<Departamento> findById(Long id);

    public Optional<Departamento> findByNombre(String nombre);

    public List<Departamento> findByNombreContainingIgnoreCaseOrderByNombreAsc(String nombre);

    public List<Departamento> findByNombreContainingIgnoreCaseOrderByNombreDesc(String nombre);

    public void deleteById(Long id);
}
