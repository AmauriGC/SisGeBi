package com.sisgebi.controller;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.service.AreaComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areaComun")
public class AreaComunController {

    @Autowired
    private AreaComunService areaComunService;

    @GetMapping("/getAll")
    public List<AreaComun> getAllAreaComun() {
        return areaComunService.getAll();
    }

    @GetMapping("/getAllById/{id}")
    public AreaComun getAllAreaComunById(@PathVariable Long id) {
        return areaComunService.getAllAreaComunById(id);
    }

    @PostMapping("/createAreaComun")
    public AreaComun createAreaComun(@RequestBody AreaComun areaComun) {
        return areaComunService.createAreaComun(areaComun);
    }

    @PutMapping("/updateAreaComun/{id}")
    public AreaComun updateAreaComun(@PathVariable Long id, @RequestBody AreaComun areaComun) {
        return areaComunService.updateAreaComun(id, areaComun);
    }

    @DeleteMapping("/deleteAreaComun/{id}")
    public void deleteAreaComun(@PathVariable Long id) {
        areaComunService.deleteAreaComun(id);
    }
}
