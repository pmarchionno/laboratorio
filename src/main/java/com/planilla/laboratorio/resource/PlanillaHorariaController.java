package com.planilla.laboratorio.resource;

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

import com.planilla.laboratorio.model.PlanillaHoraria;
import com.planilla.laboratorio.repository.DepartamentoRepo;
import com.planilla.laboratorio.service.PlanillaHorariaService;

@RestController
@RequestMapping("/laboratorio/planilla-horaria")
public class PlanillaHorariaController {
    PlanillaHorariaService planillaHorariaService;

    // @Autowired
    // private HorarioRepo horarioRepo;
    
    // @Autowired
    // private CursoRepo cursoRepo;

    // @Autowired
    // private MateriaRepo materiaRepo;

    // @Autowired
    // private PersonalRepo personalRepo;

    @Autowired
    DepartamentoRepo departamentoRepo;

    public PlanillaHorariaController(PlanillaHorariaService planillaHorariaService) {
        this.planillaHorariaService = planillaHorariaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlanillaHoraria>> getAllPlanillaHorarias() {
        List<PlanillaHoraria> planillaHorarias = planillaHorariaService.findAllPlanillaHorarias();
        return new ResponseEntity<>(planillaHorarias, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PlanillaHoraria> getPlanillaHorariaById(@PathVariable("id") Long id) {
        PlanillaHoraria planillaHoraria = planillaHorariaService.findPlanillaHorariaById(id);
        return new ResponseEntity<>(planillaHoraria, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PlanillaHoraria> addPlanillaHoraria(@RequestBody PlanillaHoraria planillaHoraria) {        
        // for (Horario horario : planillaHoraria.getHorarios()) {
        //     Horario existingHorario = horarioRepo.findById(horario.getId()).orElse(null);
        //     if (existingHorario != null) {
        //         // horario = existingHorario;
        //     } else {
        //         horarioRepo.save(horario);
        //     }
        // }
        
        // for (Curso curso : planillaHoraria.getCursos()) {
        //     // Busca el curso en la base de datos por su ID o nombre, por ejemplo, usando el
        //     // cursoRepository.
        //     Curso existingCurso = cursoRepo.findById(curso.getId()).orElse(null);
        //     if (existingCurso != null) {
        //         // // Actualiza la referencia del curso en la planilla con el curso existente.
        //         // curso = existingCurso;
        //     } else {
        //         // Manejar el caso en el que el curso no existe en la base de datos.
        //         // Puedes lanzar una excepción, devolver un error, o realizar alguna acción
        //         // personalizada.
        //         // Aquí, asumiremos que si el curso no existente, entonces se agregará a la BD.
        //         cursoRepo.save(curso);
        //     }
        // }

        // for (Materia materia : planillaHoraria.getMaterias()) {
        //     Materia existingMateria = materiaRepo.findById(materia.getId()).orElse(null);
        //     if (existingMateria != null) {
        //         // materia = existingMateria;
        //     } else {
        //         Departamento dpto = departamentoRepo.findById(materia.getDepartamento().getId())
        //             .orElse(null);
        //         if (dpto != null) {
        //             // El departamento existe
        //         } else {
        //             // Agregamos el departamento a la BD.
        //             Departamento newDpto = departamentoRepo.save(materia.getDepartamento());
        //             materia.setDepartamento(newDpto);
        //         }
        //         materiaRepo.save(materia);
        //     }
        // }

        // for (Personal personal : planillaHoraria.getDocentes()) {
        //     Personal existingDocente = personalRepo.findById(personal.getId()).orElse(null);
        //     if (existingDocente != null) {
        //         // personal = existingPersonal;
        //     } else {
        //         personalRepo.save(personal);
        //     }
        // }
        
        PlanillaHoraria newPlanillaHoraria = planillaHorariaService.addPlanillaHoraria(planillaHoraria);
        return new ResponseEntity<>(newPlanillaHoraria, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PlanillaHoraria> updatePlanillaHoraria(@RequestBody PlanillaHoraria planillaHoraria) {
        PlanillaHoraria updatePlanillaHoraria = planillaHorariaService.updatePlanillaHoraria(planillaHoraria);
        return new ResponseEntity<>(updatePlanillaHoraria, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlanillaHoraria(@PathVariable("id") Long id) {
        planillaHorariaService.deletePlanillaHoraria(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
