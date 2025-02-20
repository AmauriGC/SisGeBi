package com.sisgebi.controller;

import com.sisgebi.entity.Responsable;
import com.sisgebi.response.ResponsableResponseRest;
import com.sisgebi.service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/responsable")
public class ResponsableController {

    @Autowired
    private ResponsableService responsableService;

    // Obtener todos los responsables
    @GetMapping("/getAll")
    public ResponseEntity<ResponsableResponseRest> getAllResponsables() {
        return responsableService.getAllResponsables();
    }

    // Obtener responsable por usuario
    @GetMapping("/getByUsuario/{usuario}")
    public ResponseEntity<ResponsableResponseRest> getResponsableByUsuario(@PathVariable String usuario) {
        return responsableService.getResponsableByUsuario(usuario);
    }

    // Crear responsable
    @PostMapping("/createResponsable")
    public ResponseEntity<ResponsableResponseRest> createResponsable(@RequestBody Responsable responsable) {
        return responsableService.createResponsable(responsable);
    }

    // Actualizar responsable
    @PutMapping("/update/{usuario}")
    public ResponseEntity<ResponsableResponseRest> updateResponsable(
            @PathVariable String usuario, @RequestBody Responsable responsable) {
        return responsableService.updateResponsable(usuario, responsable);
    }

    // Eliminar responsable
    @DeleteMapping("/delete/{usuario}")
    public ResponseEntity<ResponsableResponseRest> deleteResponsable(@PathVariable String usuario) {
        return responsableService.deleteResponsable(usuario);
    }
}
