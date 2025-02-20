package com.sisgebi.service;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.repository.AreaComunRepository;
import com.sisgebi.response.AreaComunResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaComunService {

    @Autowired
    private AreaComunRepository areaComunRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<AreaComunResponseRest> getAllAreaComunes() {
        AreaComunResponseRest response = new AreaComunResponseRest();
        List<AreaComun> areaComunes = new ArrayList<>();

        try {
            areaComunes = areaComunRepository.findAll();
            response.getAreaComunResponse().setAreaComunes(areaComunes);
            response.setMetadata("Respuesta OK", "00", "Consulta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta FALLIDA", "-1", "Error al consultar las áreas comunes");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<AreaComunResponseRest> getAreaComunByNombreArea(String nombreArea) {
        AreaComunResponseRest response = new AreaComunResponseRest();
        List<AreaComun> list = new ArrayList<>();

        try {
            AreaComun areaComun = areaComunRepository.findByNombreArea(nombreArea);
            if (areaComun != null) {
                list.add(areaComun);
                response.getAreaComunResponse().setAreaComunes(list);
                response.setMetadata("Respuesta OK", "00", "Área común encontrada");
            } else {
                response.setMetadata("Respuesta No Encontrada", "-1", "Área común no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al consultar el área común");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<AreaComunResponseRest> createAreaComun(AreaComun areaComun) {
        AreaComunResponseRest response = new AreaComunResponseRest();
        List<AreaComun> list = new ArrayList<>();

        try {
            areaComun.setCreatedAt(LocalDateTime.now());
            areaComun.setUpdatedAt(LocalDateTime.now());
            AreaComun areaComunSaved = areaComunRepository.save(areaComun);
            if (areaComunSaved != null) {
                list.add(areaComunSaved);
                response.getAreaComunResponse().setAreaComunes(list);
                response.setMetadata("Respuesta OK", "00", "Área común creada exitosamente");
            } else {
                response.setMetadata("Error", "-1", "No se pudo crear el área común");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al crear el área común");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<AreaComunResponseRest> updateAreaComun(String nombreArea, AreaComun areaComun) {
        AreaComunResponseRest response = new AreaComunResponseRest();

        try {
            AreaComun existingAreaComun = areaComunRepository.findByNombreArea(nombreArea);

            if (existingAreaComun == null) {
                response.setMetadata("Error", "-1", "Área común no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            existingAreaComun.setNombreArea(areaComun.getNombreArea());
            existingAreaComun.setDescripcion(areaComun.getDescripcion());
            existingAreaComun.setStatus(areaComun.getStatus());
            existingAreaComun.setUpdatedAt(LocalDateTime.now());

            areaComunRepository.save(existingAreaComun);

            response.getAreaComunResponse().setAreaComunes(List.of(existingAreaComun));
            response.setMetadata("Actualización Exitosa", "00", "Área común actualizada correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar el área común");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<AreaComunResponseRest> deleteAreaComun(String nombreArea) {
        AreaComunResponseRest response = new AreaComunResponseRest();

        try {
            AreaComun areaComun = areaComunRepository.findByNombreArea(nombreArea);

            if (areaComun == null) {
                response.setMetadata("Error", "-1", "Área común no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            areaComunRepository.delete(areaComun);

            response.setMetadata("Eliminación Exitosa", "00", "Área común eliminada correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar el área común");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
