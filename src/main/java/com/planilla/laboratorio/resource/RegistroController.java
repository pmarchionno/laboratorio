package com.planilla.laboratorio.resource;

import org.springframework.web.bind.annotation.RestController;

import com.planilla.laboratorio.model.Registro;
import com.planilla.laboratorio.repository.CursoRepo;
import com.planilla.laboratorio.repository.MateriaRepo;
import com.planilla.laboratorio.repository.PersonalRepo;
import com.planilla.laboratorio.service.RegistroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/laboratorio/registros")

public class RegistroController {
    RegistroService registroService;

    @Autowired
    CursoRepo cursoRepo;

    @Autowired
    MateriaRepo materiaRepo;

    @Autowired
    PersonalRepo personalRepo;

    public RegistroController(RegistroService registroService){
        this.registroService = registroService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Registro>> getAllRegistros() {
        List<Registro> registros = registroService.findAllRegistros();
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Registro> getRegistroById(@PathVariable("id") Long id) {
        Registro registros = registroService.findRegistroById(id);
        return new ResponseEntity<>(registros, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Registro> addRegistroById(@RequestBody Registro registro) {
        Registro registros = registroService.addRegistro(registro);
        return new ResponseEntity<>(registros, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Registro> updateRegistro(@RequestBody Registro registro) {
        Registro registros = registroService.updateRegistro(registro);
        return new ResponseEntity<>(registros, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Registro> deleteRegistro(@PathVariable("id") Long id) {
        registroService.deleteRegistro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
