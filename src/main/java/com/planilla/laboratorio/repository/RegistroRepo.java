package com.planilla.laboratorio.repository;

import java.util.Optional;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.planilla.laboratorio.model.Curso;
import com.planilla.laboratorio.model.Materia;
import com.planilla.laboratorio.model.Personal;
import com.planilla.laboratorio.model.Registro;

@Repository
public interface RegistroRepo extends JpaRepository<Registro, Long>{
    public Optional<Registro> findById(Long id);
    public List<Registro> findByFecha(Date fecha);

    @Query("SELECT r FROM Registro r WHERE r.hora_inicio = ?1")
    public List<Registro> findByHora_inicio(String hora);

    @Query("SELECT r FROM Registro r WHERE r.hora_inicio = ?1")
    public List<Registro> findByHora_fin(String hora);
    
    public List<Registro> findByCurso(Curso curso);
    public List<Registro> findByMateria(Materia materia);
    public List<Registro> findByPersonal(Personal personal);
    public void deleteById(Long id);
}
