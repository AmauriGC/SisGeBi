package com.sisgebi.controller;

import com.sisgebi.entity.Becario;
import com.sisgebi.response.BecarioResponseRest;
import com.sisgebi.service.BecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/becario")
public class BecarioController {

    @Autowired
    private BecarioService becarioService;

    // Obtener todos los becarios
    @GetMapping("/getAll")
    public ResponseEntity<BecarioResponseRest> getAllBecarios() {
        return becarioService.getAllBecarios();
    }

    // Obtener becario por usuario
    @GetMapping("/getByUsuario/{usuario}")
    public ResponseEntity<BecarioResponseRest> getBecarioByUsuario(@PathVariable String usuario) {
        return becarioService.getBecarioByUsuario(usuario);
    }

    // Crear becario
    @PostMapping("/createBecario")
    public ResponseEntity<BecarioResponseRest> createBecario(@RequestBody Becario becario) {
        return becarioService.createBecario(becario);
    }

    // Actualizar becario
    @PutMapping("/update/{usuario}")
    public ResponseEntity<BecarioResponseRest> updateBecario(
            @PathVariable String usuario, @RequestBody Becario becario) {
        return becarioService.updateBecario(usuario, becario);
    }

    // Eliminar becario
    @DeleteMapping("/delete/{usuario}")
    public ResponseEntity<BecarioResponseRest> deleteBecario(@PathVariable String usuario) {
        return becarioService.deleteBecario(usuario);
    }
}
