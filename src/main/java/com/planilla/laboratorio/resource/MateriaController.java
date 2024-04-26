package com.planilla.laboratorio.resource;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.planilla.laboratorio.model.Materia;
import com.planilla.laboratorio.repository.DepartamentoRepo;
import com.planilla.laboratorio.service.MateriaService;

@RestController
@RequestMapping("/laboratorio/materias")
public class MateriaController {
    private final MateriaService materiaService;

    @Autowired
    DepartamentoRepo departamentoRepo;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Materia>> getAllMaterias() {
        List<Materia> materias = materiaService.findAllMaterias();
        return new ResponseEntity<>(materias, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable("id") Long id) {
        Materia materia = materiaService.findMateriaById(id);
        return new ResponseEntity<>(materia, HttpStatus.OK);
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<Materia>> findByNombreContainingIgnoreCase(@PathVariable("name") String name) throws SQLException {
        List<Materia> materia = materiaService.findByNombreContainingIgnoreCase(name);
        return new ResponseEntity<>(materia, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Materia> addMateria(@RequestBody Materia materia) {
        // Busca el departamento en la base de datos por su ID o nombre, por ejemplo,
        // usando el
        // departamentoRepo.
        Departamento dpto = departamentoRepo.findById(materia.getDepartamento().getId())
            .orElse(null);
        if (dpto != null) {
            // El departamento existe
        } else {
            // Agregamos el departamento a la BD.
            departamentoRepo.save(materia.getDepartamento());
        }

        Materia newMateria = materiaService.addMateria(materia);
        return new ResponseEntity<>(newMateria, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Materia> updateMateria(@RequestBody Materia materia) {
        Materia updateMateria = materiaService.updateMateria(materia);
        return new ResponseEntity<>(updateMateria, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMateria(@PathVariable("id") Long id) {
        materiaService.deleteMateria(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
