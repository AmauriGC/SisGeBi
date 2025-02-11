package com.sisgebi.controller;

import com.sisgebi.entity.Marca;
import com.sisgebi.response.MarcaResponseRest;
import com.sisgebi.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/getAll")
    public ResponseEntity<MarcaResponseRest> getAllMarca() {
        return marcaService.getAllMarcas();
    }

    @GetMapping("/getAllById/{id}")
    public ResponseEntity<MarcaResponseRest> getMarcaById(@PathVariable Long id) {
        return marcaService.getMarcaById(id);
    }

    @PostMapping("/createMarca")
    public ResponseEntity<MarcaResponseRest> createMarca(@RequestBody Marca marca) {
        return marcaService.createMarca(marca);
    }

    @PutMapping("/updateMarca/{id}")
    public ResponseEntity<MarcaResponseRest> updateMarca(@PathVariable Long id, @RequestBody Marca marca) {
        return marcaService.updateMarca(id, marca);
    }

    @DeleteMapping("/deleteMarca/{id}")
    public ResponseEntity<MarcaResponseRest> deleteMarca(@PathVariable Long id) {
        return marcaService.deleteMarca(id);
    }
}
