package com.planilla.laboratorio.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Curso.class)
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    // @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    // @JsonIgnore
    // private List<PlanillaHoraria> planillas;

    // @ManyToMany(mappedBy = "cursos", fetch = FetchType.EAGER)
    // @JsonIgnore
    // private Set<PlanillaHoraria> planillaHoraria = new HashSet<>();

    // @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    // private Set<PlanillaHoraria> planillaHoraria = new HashSet<>();
}
