package com.sisgebi.controller;

import com.sisgebi.entity.Bien;
import com.sisgebi.service.BienService;
import com.sisgebi.response.BienResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bien")
public class BienController {

    @Autowired
    private BienService bienService;

    @GetMapping("/getAll")
    public ResponseEntity<BienResponseRest> getAllBienes() {
        return bienService.getAllBienes();
    }

    @GetMapping("/getAllById/{id}")
    public ResponseEntity<BienResponseRest> getBienById(@PathVariable Long id) {
        return bienService.getBienById(id);
    }

    @PostMapping("/createBien")
    public ResponseEntity<BienResponseRest> createBien(@RequestBody Bien bien) {
        return bienService.createBien(bien);
    }

    @PutMapping("/updateBien/{id}")
    public ResponseEntity<BienResponseRest> updateBien(@PathVariable Long id, @RequestBody Bien bien) {
        return bienService.updateBien(id, bien);
    }

    @DeleteMapping("/deleteBien/{id}")
    public ResponseEntity<BienResponseRest> deleteBien(@PathVariable Long id) {
        return bienService.deleteBien(id);
    }
}
