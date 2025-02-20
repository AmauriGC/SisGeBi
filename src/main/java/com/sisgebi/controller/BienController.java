package com.sisgebi.controller;

import com.sisgebi.entity.Bien;
import com.sisgebi.response.BienResponseRest;
import com.sisgebi.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bien")
public class BienController {

    @Autowired
    private BienService bienService;

    // Obtener todos los bienes
    @GetMapping("/getAll")
    public ResponseEntity<BienResponseRest> getAllBienes() {
        return bienService.getAllBienes();
    }

    // Obtener un bien por el código
    @GetMapping("/getByCodigo/{codigo}")
    public ResponseEntity<BienResponseRest> getBienByCodigo(@PathVariable String codigo) {
        return bienService.getBienByCodigo(codigo);  // Llamamos al servicio con el código del bien
    }

    // Crear un nuevo bien
    @PostMapping("/createBien")
    public ResponseEntity<BienResponseRest> createBien(@RequestBody Bien bien) {
        return bienService.createBien(bien);
    }

    // Actualizar un bien existente por código
    @PutMapping("/updateByCodigo/{codigo}")
    public ResponseEntity<BienResponseRest> updateBienByCodigo(@PathVariable String codigo, @RequestBody Bien bien) {
        return bienService.updateBien(codigo, bien);  // Llamamos al servicio con el código del bien
    }

    // Eliminar un bien por código
    @DeleteMapping("/deleteByCodigo/{codigo}")
    public ResponseEntity<BienResponseRest> deleteBienByCodigo(@PathVariable String codigo) {
        return bienService.deleteBien(codigo);  // Llamamos al servicio con el código del bien
    }
}
