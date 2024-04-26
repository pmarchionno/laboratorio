package com.planilla.laboratorio.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.planilla.laboratorio.exception.LocalNotFoundException;
import com.planilla.laboratorio.model.Materia;
import com.planilla.laboratorio.repository.MateriaRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MateriaService {
    private MateriaRepo materiaRepo;

    public MateriaService(MateriaRepo materiaRepo) {
        this.materiaRepo = materiaRepo;
    }

    public Materia addMateria(Materia materia) {
        return materiaRepo.save(materia);
    }

    public List<Materia> findAllMaterias() {
        return materiaRepo.findAll();
    }

    public List<Materia> findMateriaByNombre(String name) {
        return materiaRepo.findByNombre(name);
    }

    public Materia findMateriaById(Long id) {
        return materiaRepo.findById(id)
                .orElseThrow(() -> new LocalNotFoundException("No se ha encontrado ningún materia con el id " + id));
    }

    public List<Materia> findByNombreContainingIgnoreCase(String nombre) throws SQLException {
        List<Materia> materias = materiaRepo.findByNombreContainingIgnoreCaseOrderByNombreAsc(nombre);
        return materias;
    }

    public Materia updateMateria(Materia materia) {
        return materiaRepo.save(materia);
    }

    public void deleteMateria(Long id) {
        materiaRepo.deleteById(id);
    }
}
