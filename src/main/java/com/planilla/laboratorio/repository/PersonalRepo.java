package com.planilla.laboratorio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.planilla.laboratorio.model.ECargo;
import com.planilla.laboratorio.model.Personal;
import java.util.List;

@Repository
public interface PersonalRepo extends JpaRepository<Personal, Long> {
    public Optional<Personal> findById(Long id);

    public Optional<Personal> findByNombre(String nombre);

    public List<Personal> findByNombreContainingIgnoreCaseOrderByNombreAsc(String nombre);

    public List<Personal> findByApellido(String apellido);

    public List<Personal> findByCargo(ECargo cargo);

    public void deleteById(Long id);
}
