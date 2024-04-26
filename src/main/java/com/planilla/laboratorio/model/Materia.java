package com.planilla.laboratorio.model;

import java.io.Serializable;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Materia.class)
public class Materia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    // @ManyToOne(fetch = FetchType.EAGER)
    // // @JsonIgnore
    // private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;

    // @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    // @JsonIgnore
    // private List<PlanillaHoraria> planillas;

    // @ManyToMany(mappedBy = "materias", fetch = FetchType.EAGER)
    // // @JsonIgnore
    // private Set<PlanillaHoraria> planillaHoraria = new HashSet<>();


    // @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    // private Set<PlanillaHoraria> planillaHoraria;
}
