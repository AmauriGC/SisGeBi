package com.sisgebi.controller;

import com.sisgebi.entity.TipoBien;
import com.sisgebi.response.TipoBienResponseRest;
import com.sisgebi.service.TipoBienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipoBien")
public class TipoBienController {

    @Autowired
    private TipoBienService tipoBienService;

    // Obtener todos los tipos de bien
    @GetMapping("/getAll")
    public ResponseEntity<TipoBienResponseRest> getAllTipoBienes() {
        return tipoBienService.getAllTipoBienes();
    }

    // Obtener un tipo de bien por el nombre
    @GetMapping("/getByNombreTipoBien/{nombreTipoBien}")
    public ResponseEntity<TipoBienResponseRest> getTipoBienByNombre(@PathVariable String nombreTipoBien) {
        return tipoBienService.getTipoBienByNombre(nombreTipoBien);
    }

    // Crear un nuevo tipo de bien
    @PostMapping("/createTipoBien")
    public ResponseEntity<TipoBienResponseRest> createTipoBien(@RequestBody TipoBien tipoBien) {
        return tipoBienService.createTipoBien(tipoBien);
    }

    // Actualizar un tipo de bien existente
    @PutMapping("/updateByNombreTipoBien/{nombreTipoBien}")
    public ResponseEntity<TipoBienResponseRest> updateTipoBienByNombre(@PathVariable String nombreTipoBien, @RequestBody TipoBien tipoBien) {
        return tipoBienService.updateTipoBien(nombreTipoBien, tipoBien);
    }

    // Eliminar un tipo de bien
    @DeleteMapping("/deleteByNombreTipoBien/{nombreTipoBien}")
    public ResponseEntity<TipoBienResponseRest> deleteTipoBienByNombre(@PathVariable String nombreTipoBien) {
        return tipoBienService.deleteTipoBien(nombreTipoBien);
    }
}
