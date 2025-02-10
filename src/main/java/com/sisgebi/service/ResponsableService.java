package com.sisgebi.service;

import com.sisgebi.entity.Responsable;
import com.sisgebi.repository.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ResponsableService {

    @Autowired
    private ResponsableRepository responsableRepository;

    public Responsable createResponsable(Responsable responsable) {
        return responsableRepository.save(responsable);
    }

    public Responsable updateResponsable(Long id, Responsable responsable) {
        if (responsableRepository.existsById(id)) {
            responsable.setIdResponsable(id);
            return responsableRepository.save(responsable);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Responsable no encontrado con id: " + id);
    }

    public void deleteResponsable(Long id) {
        if (responsableRepository.existsById(id)) {
            responsableRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Responsable no encontrado con id: " + id);
        }
    }

    public List<Responsable> getAll() {
        return responsableRepository.findAll();
    }

    public Responsable getAllResponsableById(Long id) {
        return responsableRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Responsable no encontrado con id: " + id));
    }
}
