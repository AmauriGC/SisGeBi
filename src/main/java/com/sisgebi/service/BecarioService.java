package com.sisgebi.service;

import com.sisgebi.entity.Becario;
import com.sisgebi.repository.BecarioRepository;
import com.sisgebi.response.BecarioResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BecarioService {

    @Autowired
    private BecarioRepository becarioRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<BecarioResponseRest> getAllBecarios() {
        BecarioResponseRest response = new BecarioResponseRest();
        List<Becario> becarios = new ArrayList<>();

        try {
            becarios = becarioRepository.findAll();
            response.getBecarioResponse().setBecarios(becarios);
            response.setMetadata("Respuesta OK", "00", "Consulta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta FALLIDA", "-1", "Error al consultar los becarios");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<BecarioResponseRest> getBecarioByUsuario(String usuario) {
        BecarioResponseRest response = new BecarioResponseRest();
        List<Becario> list = new ArrayList<>();

        try {
            Becario becario = becarioRepository.findByUsuario(usuario);
            if (becario != null) {
                list.add(becario);
                response.getBecarioResponse().setBecarios(list);
                response.setMetadata("Respuesta OK", "00", "Becario encontrado");
            } else {
                response.setMetadata("Respuesta No Encontrada", "-1", "Becario no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al consultar el becario");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<BecarioResponseRest> createBecario(Becario becario) {
        BecarioResponseRest response = new BecarioResponseRest();
        List<Becario> list = new ArrayList<>();

        try {
            becario.setCreatedAt(LocalDateTime.now());
            becario.setUpdatedAt(LocalDateTime.now());
            Becario becarioSaved = becarioRepository.save(becario);
            if (becarioSaved != null) {
                list.add(becarioSaved);
                response.getBecarioResponse().setBecarios(list);
                response.setMetadata("Respuesta OK", "00", "Becario creado exitosamente");
            } else {
                response.setMetadata("Error", "-1", "No se pudo crear el becario");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al crear el becario");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<BecarioResponseRest> updateBecario(String usuario, Becario becario) {
        BecarioResponseRest response = new BecarioResponseRest();

        try {
            Becario existingBecario = becarioRepository.findByUsuario(usuario);

            if (existingBecario == null) {
                response.setMetadata("Error", "-1", "Becario no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            existingBecario.setNombreCompleto(becario.getNombreCompleto());
            existingBecario.setContraseña(becario.getContraseña());
            existingBecario.setStatus(becario.getStatus());
            existingBecario.setUpdatedAt(LocalDateTime.now());

            becarioRepository.save(existingBecario);

            response.getBecarioResponse().setBecarios(List.of(existingBecario));
            response.setMetadata("Actualización Exitosa", "00", "Becario actualizado correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar el becario");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<BecarioResponseRest> deleteBecario(String usuario) {
        BecarioResponseRest response = new BecarioResponseRest();

        try {
            Becario becario = becarioRepository.findByUsuario(usuario);

            if (becario == null) {
                response.setMetadata("Error", "-1", "Becario no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            becarioRepository.delete(becario);

            response.setMetadata("Eliminación Exitosa", "00", "Becario eliminado correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar el becario");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
