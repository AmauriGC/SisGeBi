package com.sisgebi.service;

import com.sisgebi.entity.TipoBien;
import com.sisgebi.repository.TipoBienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TipoBienService {

    @Autowired
    private TipoBienRepository tipoBienRepository;

    public TipoBien createTipoBien(TipoBien tipoBien) {
        return tipoBienRepository.save(tipoBien);
    }

    public TipoBien updateTipoBien(Long id, TipoBien tipoBien) {
        if (tipoBienRepository.existsById(id)) {
            tipoBien.setIdTipoBien(id);
            return tipoBienRepository.save(tipoBien);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de Bien no encontrado con id: " + id);
    }

    public void deleteTipoBien(Long id) {
        if (tipoBienRepository.existsById(id)) {
            tipoBienRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de Bien no encontrado con id: " + id);
        }
    }

    public List<TipoBien> getAll() {
        return tipoBienRepository.findAll();
    }

    public TipoBien getAllTipoBienById(Long id) {
        return tipoBienRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de Bien no encontrado con id: " + id));
    }
}
