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

import com.planilla.laboratorio.model.Personal;
import com.planilla.laboratorio.service.PersonalService;

@RestController
@RequestMapping("/laboratorio/personals")

public class PersonalController {
    private PersonalService personalService;

    public PersonalController(PersonalService personalService){
        this.personalService = personalService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Personal>> getAllPersonals() {
        List<Personal> personals = personalService.findAllPersonals();
        return new ResponseEntity<>(personals, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Personal> getPersonalById(@PathVariable("id") Long id) {
        Personal personal = personalService.findPersonalById(id);
        return new ResponseEntity<>(personal, HttpStatus.OK);
    }

    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<Personal>> findByNombreContainingIgnoreCase(@PathVariable("name") String name) throws SQLException {
        List<Personal> personal = personalService.findByNombreContainingIgnoreCase(name);
        return new ResponseEntity<>(personal, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Personal> addPersonal(@RequestBody Personal personal) {
        Personal newPersonal = personalService.addPersonal(personal);
        return new ResponseEntity<>(newPersonal, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Personal> updatePersonal(@RequestBody Personal personal) {
        Personal updatePersonal = personalService.updatePersonal(personal);
        return new ResponseEntity<>(updatePersonal, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersonal(@PathVariable("id") Long id) {
        personalService.deletePersonal(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
