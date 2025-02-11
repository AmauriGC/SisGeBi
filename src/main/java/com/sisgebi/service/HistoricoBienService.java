package com.sisgebi.service;

import com.sisgebi.entity.HistoricoBien;
import com.sisgebi.repository.HistoricoBienRepository;
import com.sisgebi.response.HistoricoBienResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoricoBienService {

    @Autowired
    private HistoricoBienRepository historicoBienRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<HistoricoBienResponseRest> getAllHistoricoBienes() {
        HistoricoBienResponseRest response = new HistoricoBienResponseRest();
        List<HistoricoBien> historicoBienes = new ArrayList<>();

        try {
            historicoBienes = historicoBienRepository.findAll();
            response.getHistoricoBienResponse().setHistoricos(historicoBienes);
            response.setMetadata("Respuesta OK", "00", "Consulta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta FALLIDA", "-1", "Error al consultar los historicos de bienes");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<HistoricoBienResponseRest> getHistoricoBienById(Long id) {
        HistoricoBienResponseRest response = new HistoricoBienResponseRest();
        List<HistoricoBien> list = new ArrayList<>();

        try {
            HistoricoBien historicoBien = historicoBienRepository.findById(id).orElse(null);
            if (historicoBien != null) {
                list.add(historicoBien);
                response.getHistoricoBienResponse().setHistoricos(list);
                response.setMetadata("Respuesta OK", "00", "Histórico de bien encontrado");
            } else {
                response.setMetadata("Respuesta No Encontrada", "-1", "Histórico de bien no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al consultar el histórico de bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<HistoricoBienResponseRest> createHistoricoBien(HistoricoBien historicoBien) {
        HistoricoBienResponseRest response = new HistoricoBienResponseRest();
        List<HistoricoBien> list = new ArrayList<>();

        try {
            HistoricoBien historicoBienSaved = historicoBienRepository.save(historicoBien);
            if (historicoBienSaved != null) {
                list.add(historicoBienSaved);
                response.getHistoricoBienResponse().setHistoricos(list);
                response.setMetadata("Respuesta OK", "00", "Histórico de bien creado exitosamente");
            } else {
                response.setMetadata("Error", "-1", "No se pudo crear el histórico de bien");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al crear el histórico de bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<HistoricoBienResponseRest> updateHistoricoBien(Long id, HistoricoBien historicoBien) {
        HistoricoBienResponseRest response = new HistoricoBienResponseRest();
        List<HistoricoBien> list = new ArrayList<>();

        try {
            HistoricoBien historicoBienExistente = historicoBienRepository.findById(id).orElse(null);
            if (historicoBienExistente != null) {
                historicoBienExistente.setTipoMovimiento(historicoBien.getTipoMovimiento());
                historicoBienExistente.setDetalle(historicoBien.getDetalle());
                HistoricoBien updatedHistoricoBien = historicoBienRepository.save(historicoBienExistente);
                list.add(updatedHistoricoBien);
                response.getHistoricoBienResponse().setHistoricos(list);
                response.setMetadata("Respuesta OK", "00", "Histórico de bien actualizado exitosamente");
            } else {
                response.setMetadata("Error", "-1", "Histórico de bien no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar el histórico de bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<HistoricoBienResponseRest> deleteHistoricoBien(Long id) {
        HistoricoBienResponseRest response = new HistoricoBienResponseRest();

        try {
            historicoBienRepository.deleteById(id);
            response.setMetadata("Respuesta OK", "00", "Histórico de bien eliminado exitosamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar el histórico de bien");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
