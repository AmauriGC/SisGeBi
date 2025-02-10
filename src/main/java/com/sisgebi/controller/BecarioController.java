package com.sisgebi.controller;

import com.sisgebi.entity.Becario;
import com.sisgebi.service.BecarioService;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/becario")
@Tags
public class BecarioController {

    @Autowired
    private BecarioService becarioService;

    @GetMapping("/getAll")
    public List<Becario> getAllBecario() {
        return becarioService.getAll();
    }

    @GetMapping("/getAllById/{id}")
    public Becario getAllBecarioById(@PathVariable Long id) {
        return becarioService.getAllBecarioById(id);
    }

    @PostMapping("/createBecario")
    public Becario createBecario(@RequestBody Becario becario) {
        return becarioService.createBecario(becario);
    }

    @PutMapping("/updateBecario/{id}")
    public Becario updateBecario(@PathVariable Long id, @RequestBody Becario becario) {
        return becarioService.updateBecario(id, becario);
    }

    @DeleteMapping("/deleteBecario/{id}")
    public void deleteBecario(@PathVariable Long id) {
        becarioService.deleteBecario(id);
    }
}
