package com.sisgebi.service;

import com.sisgebi.entity.Bien;
import com.sisgebi.repository.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;

    public Bien createBien(Bien bien) {
        return bienRepository.save(bien);
    }

    public Bien updateBien(Long id, Bien bien) {
        if (bienRepository.existsById(id)) {
            bien.setIdBien(id);
            return bienRepository.save(bien);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bien no encontrado con id: " + id);
    }

    public void deleteBien(Long id) {
        if (bienRepository.existsById(id)) {
            bienRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bien no encontrado con id: " + id);
        }
    }

    public List<Bien> getAll() {
        return bienRepository.findAll();
    }

    public Bien getAllBienById(Long id) {
        return bienRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bien no encontrado con id: " + id));
    }
}
