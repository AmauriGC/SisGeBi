package com.sisgebi.controller;

import com.sisgebi.entity.Ubicacion;
import com.sisgebi.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping("/getAll")
    public List<Ubicacion> getAllUbicacion() {
        return ubicacionService.getAll();
    }

    @GetMapping("/getAllById/{id}")
    public Ubicacion getAllUbicacionById(@PathVariable Long id) {
        return ubicacionService.getAllUbicacionById(id);
    }

    @PostMapping("createUbicacion")
    public Ubicacion createUbicacion(@RequestBody Ubicacion ubicacion) {
        return ubicacionService.createUbicacion(ubicacion);
    }

    @PutMapping("updateUbicacion/{id}")
    public Ubicacion updateUbicacion(@PathVariable Long id, @RequestBody Ubicacion ubicacion) {
        return ubicacionService.updateUbicacion(id, ubicacion);
    }

    @DeleteMapping("deleteUbicacion/{id}")
    public void deleteUbicacion(@PathVariable Long id) {
        ubicacionService.deleteUbicacion(id);
    }
}
