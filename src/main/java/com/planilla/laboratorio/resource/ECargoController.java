package com.planilla.laboratorio.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planilla.laboratorio.model.ECargo;

@RestController
@RequestMapping("/laboratorio/cargos")
public class ECargoController {
    @GetMapping("/all")
    public ECargo[] getAllCargos() {
        return ECargo.values();
    }
}
