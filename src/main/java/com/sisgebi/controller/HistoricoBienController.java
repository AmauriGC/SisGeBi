package com.sisgebi.controller;

import com.sisgebi.entity.HistoricoBien;
import com.sisgebi.service.HistoricoBienService;
import com.sisgebi.response.HistoricoBienResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/historicoBien")
public class HistoricoBienController {

    @Autowired
    private HistoricoBienService historicoBienService;

    @GetMapping("/getAll")
    public ResponseEntity<HistoricoBienResponseRest> getAllHistoricoBienes() {
        return historicoBienService.getAllHistoricoBienes();
    }

    @GetMapping("/getAllById/{id}")
    public ResponseEntity<HistoricoBienResponseRest> getHistoricoBienById(@PathVariable Long id) {
        return historicoBienService.getHistoricoBienById(id);
    }

    @PostMapping("/createHistoricoBien")
    public ResponseEntity<HistoricoBienResponseRest> createHistoricoBien(@RequestBody HistoricoBien historicoBien) {
        return historicoBienService.createHistoricoBien(historicoBien);
    }

    @PutMapping("/updateHistoricoBien/{id}")
    public ResponseEntity<HistoricoBienResponseRest> updateHistoricoBien(@PathVariable Long id, @RequestBody HistoricoBien historicoBien) {
        return historicoBienService.updateHistoricoBien(id, historicoBien);
    }

    @DeleteMapping("/deleteHistoricoBien/{id}")
    public ResponseEntity<HistoricoBienResponseRest> deleteHistoricoBien(@PathVariable Long id) {
        return historicoBienService.deleteHistoricoBien(id);
    }
}
