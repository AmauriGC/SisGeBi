package com.sisgebi.controller;

import com.sisgebi.entity.Becario;
import com.sisgebi.service.BecarioService;
import com.sisgebi.response.BecarioResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/becario")
public class BecarioController {

    @Autowired
    private BecarioService becarioService;

    @GetMapping("/getAll")
    public ResponseEntity<BecarioResponseRest> getAllBecarios() {
        return becarioService.getAllBecarios();
    }

    @GetMapping("/getAllById/{id}")
    public ResponseEntity<BecarioResponseRest> getBecarioById(@PathVariable Long id) {
        return becarioService.getBecarioById(id);
    }

    @PostMapping("/createBecario")
    public ResponseEntity<BecarioResponseRest> createBecario(@RequestBody Becario becario) {
        return becarioService.createBecario(becario);
    }

    @PutMapping("/updateBecario/{id}")
    public ResponseEntity<BecarioResponseRest> updateBecario(@PathVariable Long id, @RequestBody Becario becario) {
        return becarioService.updateBecario(id, becario);
    }

    @DeleteMapping("/deleteBecario/{id}")
    public ResponseEntity<BecarioResponseRest> deleteBecario(@PathVariable Long id) {
        return becarioService.deleteBecario(id);
    }
}
