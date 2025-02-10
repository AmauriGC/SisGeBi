package com.sisgebi.controller;

import com.sisgebi.entity.Marca;
import com.sisgebi.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/getAll")
    public List<Marca> getAllMarca() {
        return marcaService.getAll();
    }

    @GetMapping("/getAllById/{id}")
    public Marca getAllMarcaById(@PathVariable Long id) {
        return marcaService.getAllMarcaById(id);
    }

    @PostMapping("/createMarca")
    public Marca createMarca(@RequestBody Marca marca) {
        return marcaService.createMarca(marca);
    }

    @PutMapping("/updateMarca/{id}")
    public Marca updateMarca(@PathVariable Long id, @RequestBody Marca marca) {
        return marcaService.updateMarca(id, marca);
    }

    @DeleteMapping("/deleteMarca/{id}")
    public void deleteMarca(@PathVariable Long id) {
        marcaService.deleteMarca(id);
    }
}
