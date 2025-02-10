package com.sisgebi.controller;

import com.sisgebi.entity.Modelo;
import com.sisgebi.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping("/getAll")
    public List<Modelo> getAllModelo() {
        return modeloService.getAll();
    }

    @GetMapping("/getAllById/{id}")
    public Modelo getAllModeloById(@PathVariable Long id) {
        return modeloService.getAllModeloById(id);
    }

    @PostMapping("/createModelo")
    public Modelo createModelo(@RequestBody Modelo modelo) {
        return modeloService.createModelo(modelo);
    }

    @PutMapping("/updateModelo/{id}")
    public Modelo updateModelo(@PathVariable Long id, @RequestBody Modelo modelo) {
        return modeloService.updateModelo(id, modelo);
    }

    @DeleteMapping("/deleteModelo/{id}")
    public void deleteModelo(@PathVariable Long id) {
        modeloService.deleteModelo(id);
    }
}
