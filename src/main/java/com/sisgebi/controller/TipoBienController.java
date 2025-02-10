package com.sisgebi.controller;

import com.sisgebi.entity.TipoBien;
import com.sisgebi.service.TipoBienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoBien")
public class TipoBienController {

    @Autowired
    private TipoBienService tipoBienService;

    @GetMapping("/getAll")
    public List<TipoBien> getAllTipoBien() {
        return tipoBienService.getAll();
    }

    @GetMapping("/getAllById/{id}")
    public TipoBien getAllTipoBienById(@PathVariable Long id) {
        return tipoBienService.getAllTipoBienById(id);
    }

    @PostMapping("createTipoBien")
    public TipoBien createTipoBien(@RequestBody TipoBien tipoBien) {
        return tipoBienService.createTipoBien(tipoBien);
    }

    @PutMapping("updateTipoBien/{id}")
    public TipoBien updateTipoBien(@PathVariable Long id, @RequestBody TipoBien tipoBien) {
        return tipoBienService.updateTipoBien(id, tipoBien);
    }

    @DeleteMapping("deleteTipoBien/{id}")
    public void deleteTipoBien(@PathVariable Long id) {
        tipoBienService.deleteTipoBien(id);
    }
}
