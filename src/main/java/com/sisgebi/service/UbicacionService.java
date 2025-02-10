package com.sisgebi.service;

import com.sisgebi.entity.Ubicacion;
import com.sisgebi.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public Ubicacion createUbicacion(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    public Ubicacion updateUbicacion(Long id, Ubicacion ubicacion) {
        if (ubicacionRepository.existsById(id)) {
            ubicacion.setIdUbicacion(id);
            return ubicacionRepository.save(ubicacion);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ubicación no encontrada con id: " + id);
    }

    public void deleteUbicacion(Long id) {
        if (ubicacionRepository.existsById(id)) {
            ubicacionRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ubicación no encontrada con id: " + id);
        }
    }

    public List<Ubicacion> getAll() {
        return ubicacionRepository.findAll();
    }

    public Ubicacion getAllUbicacionById(Long id) {
        return ubicacionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ubicación no encontrada con id: " + id));
    }
}
