package com.planilla.laboratorio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.planilla.laboratorio.exception.LocalNotFoundException;
import com.planilla.laboratorio.model.Horario;
import com.planilla.laboratorio.repository.HorarioRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HorarioService {
    private HorarioRepo horarioRepo;

    public HorarioService(HorarioRepo horarioRepo){
        this.horarioRepo = horarioRepo;
    }

    public Horario addHorario(Horario horario) {
        return horarioRepo.save(horario);
    }

    public List<Horario> findAllHorarios() {
        return horarioRepo.findAll();
    }

    public Horario findHorarioById(Long id) {
        return horarioRepo.findById(id)
                .orElseThrow(() -> new LocalNotFoundException("No se ha encontrado ningún Horario con el id " + id));
    }

    public Horario updateHorario(Horario horario) {
        return horarioRepo.save(horario);
    }

    public void deleteHorario(Long id) {
        horarioRepo.deleteById(id);
    }
}
