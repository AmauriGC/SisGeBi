package com.sisgebi.controller;

import com.sisgebi.entity.Modelo;
import com.sisgebi.response.ModeloResponseRest;
import com.sisgebi.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping("/getAll")
    public ResponseEntity<ModeloResponseRest> getAllModelos() {
        return modeloService.getAllModelos();
    }

    @GetMapping("/getAllById/{id}")
    public ResponseEntity<ModeloResponseRest> getModeloById(@PathVariable Long id) {
        return modeloService.getModeloById(id);
    }

    @PostMapping("/createModelo")
    public ResponseEntity<ModeloResponseRest> createModelo(@RequestBody Modelo modelo) {
        return modeloService.createModelo(modelo);
    }

    @PutMapping("/updateModelo/{id}")
    public ResponseEntity<ModeloResponseRest> updateModelo(@PathVariable Long id, @RequestBody Modelo modelo) {
        return modeloService.updateModelo(id, modelo);
    }

    @DeleteMapping("/deleteModelo/{id}")
    public ResponseEntity<ModeloResponseRest> deleteModelo(@PathVariable Long id) {
        return modeloService.deleteModelo(id);
    }
}
