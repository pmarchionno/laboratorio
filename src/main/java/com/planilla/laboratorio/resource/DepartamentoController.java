package com.planilla.laboratorio.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planilla.laboratorio.model.Departamento;
import com.planilla.laboratorio.service.DepartamentoService;

@RestController
@RequestMapping("/laboratorio/departamentos")
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService){
        this.departamentoService = departamentoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Departamento>> getAllDepartamentos() {
        List<Departamento> departamento = departamentoService.findAllDepartamentos();
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable("id") Long id) {
        Departamento departamento = departamentoService.findDepartamentoById(id);
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<Departamento>> findByNombreContainingIgnoreCase(@PathVariable("name") String name) {
        List<Departamento> departamento = departamentoService.findByNombreContainingIgnoreCase(name);
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Departamento> addDepartamento(@RequestBody Departamento departamento) {
        Departamento newDepartamento = departamentoService.addDepartamento(departamento);
        return new ResponseEntity<>(newDepartamento, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Departamento> updateDepartamento(@RequestBody Departamento departamento) {
        Departamento updateDepartamento = departamentoService.updateDepartamento(departamento);
        return new ResponseEntity<>(updateDepartamento, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartamento(@PathVariable("id") Long id) {
        departamentoService.deleteDepartamento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
