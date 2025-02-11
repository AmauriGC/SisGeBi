package com.sisgebi.service;

import com.sisgebi.entity.Bien;
import com.sisgebi.repository.BienRepository;
import com.sisgebi.response.BienResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<BienResponseRest> getAllBienes() {
        BienResponseRest response = new BienResponseRest();
        List<Bien> bienes = new ArrayList<>();

        try {
            bienes = bienRepository.findAll();
            response.getBienResponse().setBienes(bienes);
            response.setMetadata("Respuesta OK", "00", "Consulta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta FALLIDA", "-1", "Error al consultar los bienes");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<BienResponseRest> getBienById(Long id) {
        BienResponseRest response = new BienResponseRest();
        List<Bien> list = new ArrayList<>();

        try {
            Bien bien = bienRepository.findById(id).orElse(null);
            if (bien != null) {
                list.add(bien);
                response.getBienResponse().setBienes(list);
                response.setMetadata("Respuesta OK", "00", "Bien encontrado");
            } else {
                response.setMetadata("Respuesta No Encontrada", "-1", "Bien no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al consultar el bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<BienResponseRest> createBien(Bien bien) {
        BienResponseRest response = new BienResponseRest();
        List<Bien> list = new ArrayList<>();

        try {
            Bien bienSaved = bienRepository.save(bien);
            if (bienSaved != null) {
                list.add(bienSaved);
                response.getBienResponse().setBienes(list);
                response.setMetadata("Respuesta OK", "00", "Bien creado exitosamente");
            } else {
                response.setMetadata("Error", "-1", "No se pudo crear el bien");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al crear el bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<BienResponseRest> updateBien(Long id, Bien bien) {
        BienResponseRest response = new BienResponseRest();
        List<Bien> list = new ArrayList<>();

        try {
            Bien bienExistente = bienRepository.findById(id).orElse(null);
            if (bienExistente != null) {
                bienExistente.setCodigo(bien.getCodigo());
                bienExistente.setNumeroSerie(bien.getNumeroSerie());
                bienExistente.setEstado(bien.getEstado());
                Bien updatedBien = bienRepository.save(bienExistente);
                list.add(updatedBien);
                response.getBienResponse().setBienes(list);
                response.setMetadata("Respuesta OK", "00", "Bien actualizado exitosamente");
            } else {
                response.setMetadata("Error", "-1", "Bien no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar el bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<BienResponseRest> deleteBien(Long id) {
        BienResponseRest response = new BienResponseRest();

        try {
            bienRepository.deleteById(id);
            response.setMetadata("Respuesta OK", "00", "Bien eliminado exitosamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar el bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
