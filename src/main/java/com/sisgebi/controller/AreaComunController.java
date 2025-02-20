package com.sisgebi.controller;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.response.AreaComunResponseRest;
import com.sisgebi.service.AreaComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/areaComun")
public class AreaComunController {

    @Autowired
    private AreaComunService areaComunService;

    // Obtener todas las áreas comunes
    @GetMapping("/getAll")
    public ResponseEntity<AreaComunResponseRest> getAllAreaComunes() {
        return areaComunService.getAllAreaComunes();
    }

    // Obtener área común por nombre
    @GetMapping("/getByNombreArea/{nombreArea}")
    public ResponseEntity<AreaComunResponseRest> getAreaComunByNombreArea(@PathVariable String nombreArea) {
        return areaComunService.getAreaComunByNombreArea(nombreArea);
    }

    // Crear área común
    @PostMapping("/createAreaComun")
    public ResponseEntity<AreaComunResponseRest> createAreaComun(@RequestBody AreaComun areaComun) {
        return areaComunService.createAreaComun(areaComun);
    }

    // Actualizar área común
    @PutMapping("/update/{nombreArea}")
    public ResponseEntity<AreaComunResponseRest> updateAreaComun(
            @PathVariable String nombreArea, @RequestBody AreaComun areaComun) {
        return areaComunService.updateAreaComun(nombreArea, areaComun);
    }

    // Eliminar área común
    @DeleteMapping("/delete/{nombreArea}")
    public ResponseEntity<AreaComunResponseRest> deleteAreaComun(@PathVariable String nombreArea) {
        return areaComunService.deleteAreaComun(nombreArea);
    }
}
