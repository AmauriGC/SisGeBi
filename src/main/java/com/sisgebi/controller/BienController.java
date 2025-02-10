package com.sisgebi.controller;

import com.sisgebi.entity.Bien;
import com.sisgebi.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bien")
public class BienController {

    @Autowired
    private BienService bienService;

    @GetMapping("/getAll")
    public List<Bien> getAllBien() {
        return bienService.getAll();
    }

    @GetMapping("/getAllById/{id}")
    public Bien getAllBienById(@PathVariable Long id) {
        return bienService.getAllBienById(id);
    }

    @PostMapping("/createBien")
    public Bien createBien(@RequestBody Bien bien) {
        return bienService.createBien(bien);
    }

    @PutMapping("/updateBien/{id}")
    public Bien updateBien(@PathVariable Long id, @RequestBody Bien bien) {
        return bienService.updateBien(id, bien);
    }

    @DeleteMapping("/deleteBien/{id}")
    public void deleteBien(@PathVariable Long id) {
        bienService.deleteBien(id);
    }
}
