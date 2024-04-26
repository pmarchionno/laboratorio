package com.planilla.laboratorio.resource;

import java.sql.SQLException;
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

import com.planilla.laboratorio.model.Curso;
import com.planilla.laboratorio.model.dto.CursoDTO;
import com.planilla.laboratorio.service.CursoService;

@RestController
@RequestMapping("/laboratorio/cursos")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CursoDTO>> getAllCursos() throws SQLException {
        List<CursoDTO> curso = cursoService.findAllCursos();
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable("id") Long id) {
        Curso curso = cursoService.findCursoById(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<CursoDTO>> findByNombreContainingIgnoreCase(@PathVariable("name") String name) throws SQLException {
        List<CursoDTO> curso = cursoService.findByNombreContainingIgnoreCase(name);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Curso> addCurso(@RequestBody Curso curso) {
        Curso newCurso = cursoService.addCurso(curso);
        return new ResponseEntity<>(newCurso, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso) {
        Curso updateCurso = cursoService.updateCurso(curso);
        return new ResponseEntity<>(updateCurso, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCurso(@PathVariable("id") Long id) {
        cursoService.deleteCurso(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
