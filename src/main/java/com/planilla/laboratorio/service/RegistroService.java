package com.planilla.laboratorio.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.planilla.laboratorio.exception.LocalNotFoundException;
import com.planilla.laboratorio.model.Curso;
import com.planilla.laboratorio.model.Materia;
import com.planilla.laboratorio.model.Personal;
import com.planilla.laboratorio.model.Registro;
import com.planilla.laboratorio.repository.RegistroRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegistroService {
    private RegistroRepo registroRepo;

    public RegistroService(RegistroRepo registroRepo){
        this.registroRepo = registroRepo;
    }

    public Registro addRegistro(Registro registro) {
        return registroRepo.save(registro);
    }

    public List<Registro> findAllRegistros() {
        return registroRepo.findAll();
    }

    public Registro findRegistroById(Long id) {
        return registroRepo.findById(id)
                .orElseThrow(() -> new LocalNotFoundException("No se ha encontrado ningún registro con el id " + id));
    }

    public List<Registro> findRegistroByFecha(Date fecha) {
        return registroRepo.findByFecha(fecha);
    }

    public List<Registro> findRegistroByHora_inicio(String hora) {
        return registroRepo.findByHora_inicio(hora);
    }

    public List<Registro> findRegistroByHora_fin(String hora) {
        return registroRepo.findByHora_fin(hora);
    }

    public List<Registro> findRegistroByCurso(Curso curso) {
        return registroRepo.findByCurso(curso);
    }

    public List<Registro> findRegistroByMateria(Materia materia) {
        return registroRepo.findByMateria(materia);
    }

    public List<Registro> findRegistroByPersonal(Personal personal) {
        return registroRepo.findByPersonal(personal);
    }

    public Registro updateRegistro(Registro registro) {
        return registroRepo.save(registro);
    }

    public void deleteRegistro(Long id){
        registroRepo.deleteById(id);
    }
}
