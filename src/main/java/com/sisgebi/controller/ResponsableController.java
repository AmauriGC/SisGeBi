package com.sisgebi.controller;

import com.sisgebi.entity.Responsable;
import com.sisgebi.service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responsable")
public class ResponsableController {

    @Autowired
    private ResponsableService responsableService;

    @GetMapping("/getAll")
    public List<Responsable> getAllResponsable() {
        return responsableService.getAll();
    }

    @GetMapping("/getAllById/{id}")
    public Responsable getAllResponsableById(@PathVariable Long id) {
        return responsableService.getAllResponsableById(id);
    }

    @PostMapping("createResponsable")
    public Responsable createResponsable(@RequestBody Responsable responsable) {
        return responsableService.createResponsable(responsable);
    }

    @PutMapping("updateResponsable/{id}")
    public Responsable updateResponsable(@PathVariable Long id, @RequestBody Responsable responsable) {
        return responsableService.updateResponsable(id, responsable);
    }

    @DeleteMapping("deleteResponsable/{id}")
    public void deleteResponsable(@PathVariable Long id) {
        responsableService.deleteResponsable(id);
    }
}
