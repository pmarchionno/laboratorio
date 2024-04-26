package com.planilla.laboratorio.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.planilla.laboratorio.exception.LocalNotFoundException;
import com.planilla.laboratorio.model.Curso;
import com.planilla.laboratorio.model.dto.CursoDTO;
import com.planilla.laboratorio.repository.CursoRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CursoService {
    private CursoRepo cursoRepo;

    public CursoService(CursoRepo cursoRepo) {
        this.cursoRepo = cursoRepo;
    }

    public Curso addCurso(Curso curso) {
        return cursoRepo.save(curso);
    }

    public List<CursoDTO> findAllCursos() throws SQLException {
        List<Curso> cursos = cursoRepo.findAllByOrderByNombreAsc();
        List<CursoDTO> cursoRepoDto = this.mapResultSetToCursoDto(cursos);
        return cursoRepoDto;
    }

    public Curso findCursoById(Long id) {
        return cursoRepo.findById(id)
                .orElseThrow(() -> new LocalNotFoundException("No se ha encontrado ningún Curso con el id " + id));
    }

    public List<CursoDTO> findByNombreContainingIgnoreCase(String nombre) throws SQLException {
        List<Curso> cursos = cursoRepo.findByNombreContainingIgnoreCaseOrderByNombreAsc(nombre);
        List<CursoDTO> cursoRepoDto = this.mapResultSetToCursoDto(cursos);
        return cursoRepoDto;
        // return cursoRepo.findByNombreContainingIgnoreCaseOrderByNombreAsc(nombre)
        //         .orElseThrow(() -> new LocalNotFoundException("No se han encontrado Cursos con el nombre " + nombre));
    }

    public Curso updateCurso(Curso curso) {
        return cursoRepo.save(curso);
    }

    public void deleteCurso(Long id) {
        cursoRepo.deleteById(id);
    }

    private List<CursoDTO> mapResultSetToCursoDto(List<Curso> resultSet) throws SQLException {
        List<CursoDTO> lstCursosDTO = new ArrayList<>();
        for (int i = 0; i < resultSet.size(); i++) {
            CursoDTO cursoDto = new CursoDTO();
            cursoDto.setId(resultSet.get(i).getId());
            cursoDto.setNombre(resultSet.get(i).getNombre());
            cursoDto.setIndex(i + 1);
            lstCursosDTO.add(cursoDto);
        }
        return lstCursosDTO;
    }
}
