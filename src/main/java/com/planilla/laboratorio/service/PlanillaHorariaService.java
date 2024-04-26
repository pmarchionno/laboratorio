package com.planilla.laboratorio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.planilla.laboratorio.exception.LocalNotFoundException;
import com.planilla.laboratorio.model.PlanillaHoraria;
import com.planilla.laboratorio.repository.PlanillaHorariaRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlanillaHorariaService {
    private PlanillaHorariaRepo planillaHorariaRepo;

    public PlanillaHorariaService(PlanillaHorariaRepo planillaHorariaRepo){
        this.planillaHorariaRepo = planillaHorariaRepo;
    }

    public PlanillaHoraria addPlanillaHoraria(PlanillaHoraria planillaHoraria) {
        return planillaHorariaRepo.save(planillaHoraria);
    }

    public List<PlanillaHoraria> findAllPlanillaHorarias() {
        return planillaHorariaRepo.findAll();
    }

    public PlanillaHoraria findPlanillaHorariaById(Long id) {
        return planillaHorariaRepo.findById(id)
                .orElseThrow(() -> new LocalNotFoundException("No se ha encontrado ningún planillaHoraria con el id " + id));
    }

    public List<PlanillaHoraria> findPlanillaHorariaByDia(String dia) {
        return planillaHorariaRepo.findByDia(dia);
    }

    public PlanillaHoraria updatePlanillaHoraria(PlanillaHoraria planillaHoraria) {
        return planillaHorariaRepo.save(planillaHoraria);
    }

    public void deletePlanillaHoraria(Long id){
        planillaHorariaRepo.deleteById(id);
    }
}
