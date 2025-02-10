package com.sisgebi.controller;

import com.sisgebi.entity.HistoricoBien;
import com.sisgebi.service.HistoricoBienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historicoBien")
public class HistoricoBienController {

    @Autowired
    private HistoricoBienService historicoBienService;

    @GetMapping("/getAll")
    public List<HistoricoBien> getAllHistoricoBien() {
        return historicoBienService.getAll();
    }

    @GetMapping("/getAllById/{id}")
    public HistoricoBien getAllHistoricoBienById(@PathVariable Long id) {
        return historicoBienService.getAllHistoricoBienById(id);
    }

    @PostMapping("createHistoricoBien")
    public HistoricoBien createHistoricoBien(@RequestBody HistoricoBien historicoBien) {
        return historicoBienService.createHistoricoBien(historicoBien);
    }

    @PutMapping("updateHistoricoBien/{id}")
    public HistoricoBien updateHistoricoBien(@PathVariable Long id, @RequestBody HistoricoBien historicoBien) {
        return historicoBienService.updateHistoricoBien(id, historicoBien);
    }

    @DeleteMapping("deleteHistoricoBien/{id}")
    public void deleteHistoricoBien(@PathVariable Long id) {
        historicoBienService.deleteHistoricoBien(id);
    }
}
