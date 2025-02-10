package com.sisgebi.service;

import com.sisgebi.entity.Becario;
import com.sisgebi.repository.BecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BecarioService {

    @Autowired
    private BecarioRepository becarioRepository;

    public Becario createBecario(Becario becario) {
        return becarioRepository.save(becario);
    }

    public Becario updateBecario(Long id, Becario becario) {
        if (becarioRepository.existsById(id)) {
            becario.setIdBecario(id);
            return becarioRepository.save(becario);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Becario no encontrado con id: " + id);
    }

    public void deleteBecario(Long id) {
        if (becarioRepository.existsById(id)) {
            becarioRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Becario no encontrado con id: " + id);
        }
    }

    public List<Becario> getAll() {
        return becarioRepository.findAll();
    }

    public Becario getAllBecarioById(Long id) {
        return becarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Becario no encontrado con id: " + id));
    }
}
