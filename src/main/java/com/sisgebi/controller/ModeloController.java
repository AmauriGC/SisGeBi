package com.sisgebi.controller;

import com.sisgebi.entity.Modelo;
import com.sisgebi.response.ModeloResponseRest;
import com.sisgebi.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    // Obtener todos los modelos
    @GetMapping("/getAll")
    public ResponseEntity<ModeloResponseRest> getAllModelos() {
        return modeloService.getAllModelos();
    }

    // Obtener un modelo por nombre
    @GetMapping("/getByNombreModelo/{nombreModelo}")
    public ResponseEntity<ModeloResponseRest> getModeloByNombre(@PathVariable String nombreModelo) {
        return modeloService.getModeloByNombre(nombreModelo);
    }

    // Crear un nuevo modelo
    @PostMapping("/createModelo")
    public ResponseEntity<ModeloResponseRest> createModelo(@RequestBody Modelo modelo) {
        return modeloService.createModelo(modelo);
    }

    // Actualizar un modelo existente
    @PutMapping("/updateByNombreModelo/{nombreModelo}")
    public ResponseEntity<ModeloResponseRest> updateModelo(@PathVariable String nombreModelo, @RequestBody Modelo modelo) {
        return modeloService.updateModelo(nombreModelo, modelo);
    }

    // Eliminar un modelo
    @DeleteMapping("/deleteByNombreModelo/{nombreModelo}")
    public ResponseEntity<ModeloResponseRest> deleteModelo(@PathVariable String nombreModelo) {
        return modeloService.deleteModelo(nombreModelo);
    }
}
