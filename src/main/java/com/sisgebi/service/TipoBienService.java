package com.sisgebi.service;

import com.sisgebi.entity.TipoBien;
import com.sisgebi.repository.TipoBienRepository;
import com.sisgebi.response.TipoBienResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TipoBienService {

    @Autowired
    private TipoBienRepository tipoBienRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<TipoBienResponseRest> getAllTipoBienes() {
        TipoBienResponseRest response = new TipoBienResponseRest();
        List<TipoBien> tipoBienes = new ArrayList<>();

        try {
            tipoBienes = tipoBienRepository.findAll();
            response.getTipoBienResponse().setTipoBienes(tipoBienes);
            response.setMetadata("Respuesta OK", "00", "Consulta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta FALLIDA", "-1", "Error al consultar los tipos de bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<TipoBienResponseRest> getTipoBienByNombre(String nombreTipoBien) {
        TipoBienResponseRest response = new TipoBienResponseRest();
        List<TipoBien> list = new ArrayList<>();

        try {
            TipoBien tipoBien = tipoBienRepository.findByNombreTipoBien(nombreTipoBien);
            if (tipoBien != null) {
                list.add(tipoBien);
                response.getTipoBienResponse().setTipoBienes(list);
                response.setMetadata("Respuesta OK", "00", "Tipo de bien encontrado");
            } else {
                response.setMetadata("Respuesta No Encontrada", "-1", "Tipo de bien no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al consultar el tipo de bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<TipoBienResponseRest> createTipoBien(TipoBien tipoBien) {
        TipoBienResponseRest response = new TipoBienResponseRest();
        List<TipoBien> list = new ArrayList<>();

        try {
            tipoBien.setCreatedAt(LocalDateTime.now());
            tipoBien.setUpdatedAt(LocalDateTime.now());
            TipoBien tipoBienSaved = tipoBienRepository.save(tipoBien);
            if (tipoBienSaved != null) {
                list.add(tipoBienSaved);
                response.getTipoBienResponse().setTipoBienes(list);
                response.setMetadata("Respuesta OK", "00", "Tipo de bien creado exitosamente");
            } else {
                response.setMetadata("Error", "-1", "No se pudo crear el tipo de bien");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al crear el tipo de bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<TipoBienResponseRest> updateTipoBien(String nombreTipoBien, TipoBien tipoBien) {
        TipoBienResponseRest response = new TipoBienResponseRest();

        try {
            TipoBien existingTipoBien = tipoBienRepository.findByNombreTipoBien(nombreTipoBien);

            if (existingTipoBien == null) {
                response.setMetadata("Error", "-1", "Tipo de bien no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            existingTipoBien.setNombreTipoBien(tipoBien.getNombreTipoBien());
            existingTipoBien.setStatus(tipoBien.getStatus());
            existingTipoBien.setUpdatedAt(LocalDateTime.now());

            tipoBienRepository.save(existingTipoBien);

            response.getTipoBienResponse().setTipoBienes(List.of(existingTipoBien));
            response.setMetadata("Actualización Exitosa", "00", "Tipo de bien actualizado correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar el tipo de bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<TipoBienResponseRest> deleteTipoBien(String nombreTipoBien) {
        TipoBienResponseRest response = new TipoBienResponseRest();

        try {
            TipoBien tipoBien = tipoBienRepository.findByNombreTipoBien(nombreTipoBien);

            if (tipoBien == null) {
                response.setMetadata("Error", "-1", "Tipo de bien no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            tipoBienRepository.delete(tipoBien);

            response.setMetadata("Eliminación Exitosa", "00", "Tipo de bien eliminado correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar el tipo de bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
