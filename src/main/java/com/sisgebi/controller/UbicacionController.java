package com.sisgebi.controller;

import com.sisgebi.entity.Ubicacion;
import com.sisgebi.service.UbicacionService;
import com.sisgebi.response.UbicacionResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping("/getAll")
    public ResponseEntity<UbicacionResponseRest> getAllUbicaciones() {
        return ubicacionService.getAllUbicaciones();
    }

    @GetMapping("/getAllById/{id}")
    public ResponseEntity<UbicacionResponseRest> getUbicacionById(@PathVariable Long id) {
        return ubicacionService.getUbicacionById(id);
    }

    @PostMapping("/createUbicacion")
    public ResponseEntity<UbicacionResponseRest> createUbicacion(@RequestBody Ubicacion ubicacion) {
        return ubicacionService.createUbicacion(ubicacion);
    }

    @PutMapping("/updateUbicacion/{id}")
    public ResponseEntity<UbicacionResponseRest> updateUbicacion(@PathVariable Long id, @RequestBody Ubicacion ubicacion) {
        return ubicacionService.updateUbicacion(id, ubicacion);
    }

    @DeleteMapping("/deleteUbicacion/{id}")
    public ResponseEntity<UbicacionResponseRest> deleteUbicacion(@PathVariable Long id) {
        return ubicacionService.deleteUbicacion(id);
    }
}
