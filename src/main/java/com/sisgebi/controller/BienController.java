package com.sisgebi.controller;

import com.sisgebi.entity.Bien;
import com.sisgebi.response.BienResponseRest;
import com.sisgebi.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Obtener bien por código
    @GetMapping("/getByCodigo/{codigo}")
    public ResponseEntity<BienResponseRest> getBienByCodigo(@PathVariable String codigo) {
        return bienService.getBienByCodigo(codigo);
    }

    // Crear nuevo bien
    @PostMapping("/createBien")
    public ResponseEntity<BienResponseRest> createBien(@RequestBody Bien bien) {
        return bienService.createBien(bien);
    }

    // Actualizar bien
    @PutMapping("/update/{codigo}")
    public ResponseEntity<BienResponseRest> updateBien(@PathVariable String codigo, @RequestBody Bien bien) {
        return bienService.updateBien(codigo, bien);
    }

    // Eliminar bien
    @DeleteMapping("/delete/{codigo}")
    public ResponseEntity<BienResponseRest> deleteBien(@PathVariable String codigo) {
        return bienService.deleteBien(codigo);
    }
}
