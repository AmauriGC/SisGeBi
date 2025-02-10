package com.sisgebi.service;

import com.sisgebi.entity.Marca;
import com.sisgebi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public Marca createMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca updateMarca(Long id, Marca marca) {
        if (marcaRepository.existsById(id)) {
            marca.setIdMarca(id);
            return marcaRepository.save(marca);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca no encontrada con id: " + id);
    }

    public void deleteMarca(Long id) {
        if (marcaRepository.existsById(id)) {
            marcaRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca no encontrada con id: " + id);
        }
    }

    public List<Marca> getAll() {
        return marcaRepository.findAll();
    }

    public Marca getAllMarcaById(Long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca no encontrada con id: " + id));
    }
}
