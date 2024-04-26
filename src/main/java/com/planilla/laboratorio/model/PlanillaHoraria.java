package com.planilla.laboratorio.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = PlanillaHoraria.class)
public class PlanillaHoraria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "dia", nullable = false, length = 10)
    private String dia;

    @Column(name = "hora_inicio", nullable = false)
    private String hora_inicio;

    @Column(name = "hora_fin", nullable = false)
    private String hora_fin;

    // @Temporal(TemporalType.DATE)
    // @DateTimeFormat(style = "dd/mm/yyyy")
    // @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/mm/yyyy")
    // private Date fecha;

    // @Column(name = "hora_inicio", nullable = false)
    // // @DateTimeFormat(style = "hh:mm")
    // // @Temporal(TemporalType.TIME)
    // // private Calendar hora_inicio;
    // private String hora_inicio;

    // @Column(name = "hora_fin", nullable = false)
    // // @DateTimeFormat(style = "hh:mm")
    // // @Temporal(TemporalType.TIME)
    // // private Calendar hora_fin;
    // private String hora_fin;

    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    // @JoinTable(name = "planillaHoraria_horario",
    //            joinColumns = @JoinColumn(name = "planillaHoraria_id", referencedColumnName = "id"),
    //            inverseJoinColumns = @JoinColumn(name = "horario_id", referencedColumnName = "id"))
    // private Set<Horario> horarios = new HashSet<>();

    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    // @JoinTable(name = "planillaHoraria_curso",
    //            joinColumns = @JoinColumn(name = "planillaHoraria_id", referencedColumnName = "id"),
    //            inverseJoinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"))
    // private Set<Curso> cursos = new HashSet<>();

    // @ManyToOne
    // @JoinColumn(name = "horario_id", nullable = false)
    // private Horario horario;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "personal_id", nullable = false)
    private Personal personal;

    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    // @JoinTable(name = "planillaHoraria_materia",
    //            joinColumns = @JoinColumn(name = "planillaHoraria_id", referencedColumnName = "id"),
    //            inverseJoinColumns = @JoinColumn(name = "materia_id", referencedColumnName = "id"))
    // private Set<Materia> materias = new HashSet<>();
    
    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    // @JoinTable(name = "planillaHoraria_personal",
    //            joinColumns = @JoinColumn(name = "planillaHoraria_id", referencedColumnName = "id"),
    //            inverseJoinColumns = @JoinColumn(name = "personal_id", referencedColumnName = "id"))
    // private Set<Personal> docentes = new HashSet<>();

    // @ManyToOne
    // private Personal docente;
}
