package com.sisgebi.controller;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.response.AreaComunResponseRest;
import com.sisgebi.service.AreaComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/areaComun")
public class AreaComunController {

    @Autowired
    private AreaComunService areaComunService;

    @GetMapping("/getAll")
    public ResponseEntity<AreaComunResponseRest> getAllAreaComun() {
        return areaComunService.getAllAreaComunes();
    }

    @GetMapping("/getAllById/{id}")
    public ResponseEntity<AreaComunResponseRest> getAreaComunById(@PathVariable Long id) {
        return areaComunService.getAreaComunById(id);
    }

    @PostMapping("/createAreaComun")
    public ResponseEntity<AreaComunResponseRest> createAreaComun(@RequestBody AreaComun areaComun) {
        return areaComunService.createAreaComun(areaComun);
    }

    @PutMapping("/updateAreaComun/{id}")
    public ResponseEntity<AreaComunResponseRest> updateAreaComun(@PathVariable Long id, @RequestBody AreaComun areaComun) {
        return areaComunService.updateAreaComun(id, areaComun);
    }

    @DeleteMapping("/deleteAreaComun/{id}")
    public ResponseEntity<AreaComunResponseRest> deleteAreaComun(@PathVariable Long id) {
        return areaComunService.deleteAreaComun(id);
    }
}
