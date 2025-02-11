package com.sisgebi.controller;

import com.sisgebi.entity.Responsable;
import com.sisgebi.service.ResponsableService;
import com.sisgebi.response.ResponsableResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/responsable")
public class ResponsableController {

    @Autowired
    private ResponsableService responsableService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponsableResponseRest> getAllResponsables() {
        return responsableService.getAllResponsables();
    }

    @GetMapping("/getAllById/{id}")
    public ResponseEntity<ResponsableResponseRest> getResponsableById(@PathVariable Long id) {
        return responsableService.getResponsableById(id);
    }

    @PostMapping("/createResponsable")
    public ResponseEntity<ResponsableResponseRest> createResponsable(@RequestBody Responsable responsable) {
        return responsableService.createResponsable(responsable);
    }

    @PutMapping("/updateResponsable/{id}")
    public ResponseEntity<ResponsableResponseRest> updateResponsable(@PathVariable Long id, @RequestBody Responsable responsable) {
        return responsableService.updateResponsable(id, responsable);
    }

    @DeleteMapping("/deleteResponsable/{id}")
    public ResponseEntity<ResponsableResponseRest> deleteResponsable(@PathVariable Long id) {
        return responsableService.deleteResponsable(id);
    }
}
