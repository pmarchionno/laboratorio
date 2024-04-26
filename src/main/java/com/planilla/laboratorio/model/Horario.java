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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Horario.class)
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "hora_inicio", nullable = false)
    private String hora_inicio;

    @Column(name = "hora_fin", nullable = false)
    private String hora_fin;

    // @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    // @JsonIgnore
    // private List<PlanillaHoraria> planillas;

    // @ManyToMany(mappedBy = "horarios", fetch = FetchType.EAGER)
    // @JsonIgnore
    // private Set<PlanillaHoraria> planillaHoraria = new HashSet<>();
}
