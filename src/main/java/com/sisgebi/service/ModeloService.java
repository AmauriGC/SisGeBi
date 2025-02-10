package com.sisgebi.service;

import com.sisgebi.entity.Modelo;
import com.sisgebi.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public Modelo createModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public Modelo updateModelo(Long id, Modelo modelo) {
        if (modeloRepository.existsById(id)) {
            modelo.setIdModelo(id);
            return modeloRepository.save(modelo);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modelo no encontrado con id: " + id);
    }

    public void deleteModelo(Long id) {
        if (modeloRepository.existsById(id)) {
            modeloRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modelo no encontrado con id: " + id);
        }
    }

    public List<Modelo> getAll() {
        return modeloRepository.findAll();
    }

    public Modelo getAllModeloById(Long id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modelo no encontrado con id: " + id));
    }
}
