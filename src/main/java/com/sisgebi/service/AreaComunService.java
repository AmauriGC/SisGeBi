package com.sisgebi.service;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.repository.AreaComunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AreaComunService {

    @Autowired
    private AreaComunRepository areaComunRepository;

    public AreaComun createAreaComun(AreaComun areaComun) {
        return areaComunRepository.save(areaComun);
    }

    public AreaComun updateAreaComun(Long id, AreaComun areaComun) {
        if (areaComunRepository.existsById(id)) {
            areaComun.setIdArea(id);
            return areaComunRepository.save(areaComun);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Area Comun no encontrada con id: " + id);
    }

    public void deleteAreaComun(Long id) {
        if (areaComunRepository.existsById(id)) {
            areaComunRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Area Comun no encontrada con id: " + id);
        }
    }

    public List<AreaComun> getAll() {
        return areaComunRepository.findAll();
    }

    public AreaComun getAllAreaComunById(Long id) {
        return areaComunRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Area Comun no encontrada con id: " + id));
    }
}
