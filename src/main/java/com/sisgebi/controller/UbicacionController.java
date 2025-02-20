package com.sisgebi.controller;

import com.sisgebi.entity.Ubicacion;
import com.sisgebi.response.UbicacionResponseRest;
import com.sisgebi.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    // Obtener todas las ubicaciones
    @GetMapping("/getAll")
    public ResponseEntity<UbicacionResponseRest> getAllUbicaciones() {
        return ubicacionService.getAllUbicaciones();
    }

    // Obtener ubicaciones por tipo de ubicación ('AreaComun' o 'Becario')
    @GetMapping("/getByTipoUbicacion/{tipoUbicacion}")
    public ResponseEntity<UbicacionResponseRest> getUbicacionesByTipo(@PathVariable String tipoUbicacion) {
        return ubicacionService.getUbicacionesByTipo(tipoUbicacion);  // Llamamos al servicio con el tipo de ubicación
    }

    // Crear una nueva ubicación
    @PostMapping("/createUbicacion")
    public ResponseEntity<UbicacionResponseRest> createUbicacion(@RequestBody Ubicacion ubicacion) {
        return ubicacionService.createUbicacion(ubicacion);
    }

    // Actualizar una ubicación existente por tipo de ubicación
    @PutMapping("/updateUbicacion/{tipoUbicacion}")
    public ResponseEntity<UbicacionResponseRest> updateUbicacion(@PathVariable String tipoUbicacion, @RequestBody Ubicacion ubicacion) {
        return ubicacionService.updateUbicacion(tipoUbicacion, ubicacion);  // Llamamos al servicio con el tipo de ubicación
    }

    // Eliminar una ubicación por tipo de ubicación
    @DeleteMapping("/deleteUbicacion/{tipoUbicacion}")
    public ResponseEntity<UbicacionResponseRest> deleteUbicacion(@PathVariable String tipoUbicacion) {
        return ubicacionService.deleteUbicacion(tipoUbicacion);  // Llamamos al servicio con el tipo de ubicación
    }
}
