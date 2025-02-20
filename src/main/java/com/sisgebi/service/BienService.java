package com.sisgebi.service;

import com.sisgebi.entity.Bien;
import com.sisgebi.repository.BienRepository;
import com.sisgebi.response.BienResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
            response.setMetadata("Error", "-1", "Error al consultar los bienes");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<BienResponseRest> getBienByCodigo(String codigo) {
        BienResponseRest response = new BienResponseRest();
        List<Bien> list = new ArrayList<>();

        try {
            Bien bien = bienRepository.findByCodigo(codigo);
            if (bien != null) {
                list.add(bien);
                response.getBienResponse().setBienes(list);
                response.setMetadata("Respuesta OK", "00", "Bien encontrado");
            } else {
                response.setMetadata("Error", "-1", "Bien no encontrado");
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
            bien.setCreatedAt(LocalDateTime.now());
            bien.setUpdatedAt(LocalDateTime.now());
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
    public ResponseEntity<BienResponseRest> updateBien(String codigo, Bien bien) {
        BienResponseRest response = new BienResponseRest();

        try {
            Bien existingBien = bienRepository.findByCodigo(codigo);

            if (existingBien == null) {
                response.setMetadata("Error", "-1", "Bien no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            existingBien.setDescripcion(bien.getDescripcion());
            existingBien.setStatus(bien.getStatus());
            existingBien.setUbicacionId(bien.getUbicacionId());
            existingBien.setResponsableId(bien.getResponsableId());
            existingBien.setUpdatedAt(LocalDateTime.now());

            bienRepository.save(existingBien);

            response.getBienResponse().setBienes(List.of(existingBien));
            response.setMetadata("Actualización Exitosa", "00", "Bien actualizado correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar el bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<BienResponseRest> deleteBien(String codigo) {
        BienResponseRest response = new BienResponseRest();

        try {
            Bien bien = bienRepository.findByCodigo(codigo);

            if (bien == null) {
                response.setMetadata("Error", "-1", "Bien no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            bienRepository.delete(bien);

            response.setMetadata("Eliminación Exitosa", "00", "Bien eliminado correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar el bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
