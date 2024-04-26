package com.planilla.laboratorio.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.planilla.laboratorio.exception.LocalNotFoundException;
import com.planilla.laboratorio.model.ECargo;
import com.planilla.laboratorio.model.Personal;
import com.planilla.laboratorio.repository.PersonalRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonalService {
    private PersonalRepo personalRepo;

    public PersonalService(PersonalRepo personalRepo) {
        this.personalRepo = personalRepo;
    }

    public Personal addPersonal(Personal personal) {
        return personalRepo.save(personal);
    }

    public List<Personal> findAllPersonals() {
        return personalRepo.findAll();
    }

    public Personal findPersonalById(Long id) {
        return personalRepo.findById(id)
                .orElseThrow(() -> new LocalNotFoundException("No se ha encontrado ningún personal con el id " + id));
    }

    public List<Personal> findPersonalByCargo(ECargo cargo) {
        return personalRepo.findByCargo(cargo);
    }

    public List<Personal> findByNombreContainingIgnoreCase(String nombre) throws SQLException {
        List<Personal> personals = personalRepo.findByNombreContainingIgnoreCaseOrderByNombreAsc(nombre);
        return personals;
    }

    public Personal updatePersonal(Personal personal) {
        return personalRepo.save(personal);
    }

    public void deletePersonal(Long id){
        personalRepo.deleteById(id);
    }
}

