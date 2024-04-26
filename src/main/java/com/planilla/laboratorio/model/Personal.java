package com.planilla.laboratorio.model;

import java.io.Serializable;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Personal.class)
public class Personal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 200)
    private String apellido;

    @Column(name = "cargo", nullable = false)
    private ECargo cargo;

    // @OneToMany(mappedBy = "personal", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    // @JsonIgnore
    // private List<PlanillaHoraria> planillas;

    // @ManyToMany(mappedBy = "docentes", fetch = FetchType.EAGER)
    // @JsonIgnore
    // private Set<PlanillaHoraria> planillaHoraria = new HashSet<>();

    // @ManyToMany(mappedBy = "personals", fetch = FetchType.EAGER)
    // @JsonIgnore
    // private List<Planilla> planillas = new ArrayList<>();

    // @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL, orphanRemoval = true)
    // private Set<PlanillaHoraria> planillaHoraria = new HashSet<>();
}
