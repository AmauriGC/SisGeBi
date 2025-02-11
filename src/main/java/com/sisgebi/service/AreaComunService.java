package com.sisgebi.service;

import com.sisgebi.entity.AreaComun;
import com.sisgebi.repository.AreaComunRepository;
import com.sisgebi.response.AreaComunResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaComunService {

    @Autowired
    private AreaComunRepository areaComunRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<AreaComunResponseRest> getAllAreaComunes() {
        AreaComunResponseRest response = new AreaComunResponseRest();
        List<AreaComun> areasComunes = new ArrayList<>();

        try {
            areasComunes = areaComunRepository.findAll();
            response.getAreaComunResponse().setAreasComunes(areasComunes);
            response.setMetadata("Respuesta OK", "00", "Consulta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta FALLIDA", "-1", "Error al consultar las áreas comunes");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<AreaComunResponseRest> getAreaComunById(Long id) {
        AreaComunResponseRest response = new AreaComunResponseRest();
        List<AreaComun> list = new ArrayList<>();

        try {
            AreaComun areaComun = areaComunRepository.findById(id).orElse(null);
            if (areaComun != null) {
                list.add(areaComun);
                response.getAreaComunResponse().setAreasComunes(list);
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
            AreaComun areaComunSaved = areaComunRepository.save(areaComun);
            if (areaComunSaved != null) {
                list.add(areaComunSaved);
                response.getAreaComunResponse().setAreasComunes(list);
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
    public ResponseEntity<AreaComunResponseRest> updateAreaComun(Long id, AreaComun areaComun) {
        AreaComunResponseRest response = new AreaComunResponseRest();
        List<AreaComun> list = new ArrayList<>();

        try {
            AreaComun areaComunExistente = areaComunRepository.findById(id).orElse(null);
            if (areaComunExistente != null) {
                areaComunExistente.setNombreArea(areaComun.getNombreArea());
                areaComunExistente.setStatus(areaComun.getStatus());
                AreaComun updatedAreaComun = areaComunRepository.save(areaComunExistente);
                list.add(updatedAreaComun);
                response.getAreaComunResponse().setAreasComunes(list);
                response.setMetadata("Respuesta OK", "00", "Área común actualizada exitosamente");
            } else {
                response.setMetadata("Error", "-1", "Área común no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar el área común");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<AreaComunResponseRest> deleteAreaComun(Long id) {
        AreaComunResponseRest response = new AreaComunResponseRest();

        try {
            areaComunRepository.deleteById(id);
            response.setMetadata("Respuesta OK", "00", "Área común eliminada exitosamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar el área común");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
