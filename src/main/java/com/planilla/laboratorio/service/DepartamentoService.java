package com.planilla.laboratorio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.planilla.laboratorio.exception.LocalNotFoundException;
import com.planilla.laboratorio.model.Departamento;
import com.planilla.laboratorio.repository.DepartamentoRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartamentoService {
    private DepartamentoRepo departamentoRepo;

    public DepartamentoService(DepartamentoRepo departamentoRepo){
        this.departamentoRepo = departamentoRepo;
    }

    public Departamento addDepartamento(Departamento departamento) {
        return departamentoRepo.save(departamento);
    }

    public List<Departamento> findAllDepartamentos() {
        return departamentoRepo.findAll();
    }

    public Departamento findDepartamentoById(Long id) {
        return departamentoRepo.findById(id)
                .orElseThrow(() -> new LocalNotFoundException("No se ha encontrado ningún Deparamento con el id " + id));
    }

    public List<Departamento> findByNombreContainingIgnoreCase(String name) {
        return departamentoRepo.findByNombreContainingIgnoreCaseOrderByNombreAsc(name);
    }

    public Departamento updateDepartamento(Departamento departamento) {
        return departamentoRepo.save(departamento);
    }

    public void deleteDepartamento(Long id) {
        departamentoRepo.deleteById(id);
    }
}
