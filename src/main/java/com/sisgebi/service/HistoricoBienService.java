package com.sisgebi.service;

import com.sisgebi.entity.HistoricoBien;
import com.sisgebi.repository.HistoricoBienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HistoricoBienService {

    @Autowired
    private HistoricoBienRepository historicoBienRepository;

    public HistoricoBien createHistoricoBien(HistoricoBien historicoBien) {
        return historicoBienRepository.save(historicoBien);
    }

    public HistoricoBien updateHistoricoBien(Long id, HistoricoBien historicoBien) {
        if (historicoBienRepository.existsById(id)) {
            historicoBien.setIdHistorico(id);
            return historicoBienRepository.save(historicoBien);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Histórico de Bien no encontrado con id: " + id);
    }

    public void deleteHistoricoBien(Long id) {
        if (historicoBienRepository.existsById(id)) {
            historicoBienRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Histórico de Bien no encontrado con id: " + id);
        }
    }

    public List<HistoricoBien> getAll() {
        return historicoBienRepository.findAll();
    }

    public HistoricoBien getAllHistoricoBienById(Long id) {
        return historicoBienRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Histórico de Bien no encontrado con id: " + id));
    }
}
