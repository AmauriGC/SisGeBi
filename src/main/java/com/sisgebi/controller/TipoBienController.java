package com.sisgebi.controller;

import com.sisgebi.entity.TipoBien;
import com.sisgebi.service.TipoBienService;
import com.sisgebi.response.TipoBienResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoBien")
public class TipoBienController {

    @Autowired
    private TipoBienService tipoBienService;

    @GetMapping("/getAll")
    public ResponseEntity<TipoBienResponseRest> getAllTipoBien() {
        return tipoBienService.getAllTipoBienes();
    }

    @GetMapping("/getAllById/{id}")
    public ResponseEntity<TipoBienResponseRest> getTipoBienById(@PathVariable Long id) {
        return tipoBienService.getTipoBienById(id);
    }

    @PostMapping("/createTipoBien")
    public ResponseEntity<TipoBienResponseRest> createTipoBien(@RequestBody TipoBien tipoBien) {
        return tipoBienService.createTipoBien(tipoBien);
    }

    @PutMapping("/updateTipoBien/{id}")
    public ResponseEntity<TipoBienResponseRest> updateTipoBien(@PathVariable Long id, @RequestBody TipoBien tipoBien) {
        return tipoBienService.updateTipoBien(id, tipoBien);
    }

    @DeleteMapping("/deleteTipoBien/{id}")
    public ResponseEntity<TipoBienResponseRest> deleteTipoBien(@PathVariable Long id) {
        return tipoBienService.deleteTipoBien(id);
    }
}
