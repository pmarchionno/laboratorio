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

import com.planilla.laboratorio.model.Horario;
import com.planilla.laboratorio.service.HorarioService;


@RestController
@RequestMapping("/laboratorio/horarios")
public class HorarioController {
    private HorarioService horarioService;

    public HorarioController(HorarioService horarioService){
        this.horarioService = horarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Horario>> getAllHorarios() {
        List<Horario> horario = horarioService.findAllHorarios();
        return new ResponseEntity<>(horario, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Horario> getHorarioById(@PathVariable("id") Long id) {
        Horario horario = horarioService.findHorarioById(id);
        return new ResponseEntity<>(horario, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Horario> addHorario(@RequestBody Horario horario) {
        Horario newHorario = horarioService.addHorario(horario);
        return new ResponseEntity<>(newHorario, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Horario> updateHorario(@RequestBody Horario horario) {
        Horario updateHorario = horarioService.updateHorario(horario);
        return new ResponseEntity<>(updateHorario, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHorario(@PathVariable("id") Long id) {
        horarioService.deleteHorario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
