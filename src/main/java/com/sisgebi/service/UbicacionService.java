package com.sisgebi.service;

import com.sisgebi.entity.Ubicacion;
import com.sisgebi.repository.UbicacionRepository;
import com.sisgebi.response.UbicacionResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<UbicacionResponseRest> getAllUbicaciones() {
        UbicacionResponseRest response = new UbicacionResponseRest();
        List<Ubicacion> ubicaciones = new ArrayList<>();

        try {
            ubicaciones = ubicacionRepository.findAll();
            response.getUbicacionResponse().setUbicaciones(ubicaciones);
            response.setMetadata("Respuesta OK", "00", "Consulta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta FALLIDA", "-1", "Error al consultar las ubicaciones");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<UbicacionResponseRest> getUbicacionById(Long id) {
        UbicacionResponseRest response = new UbicacionResponseRest();
        List<Ubicacion> list = new ArrayList<>();

        try {
            Ubicacion ubicacion = ubicacionRepository.findById(id).orElse(null);
            if (ubicacion != null) {
                list.add(ubicacion);
                response.getUbicacionResponse().setUbicaciones(list);
                response.setMetadata("Respuesta OK", "00", "Ubicación encontrada");
            } else {
                response.setMetadata("Respuesta No Encontrada", "-1", "Ubicación no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al consultar la ubicación");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<UbicacionResponseRest> createUbicacion(Ubicacion ubicacion) {
        UbicacionResponseRest response = new UbicacionResponseRest();
        List<Ubicacion> list = new ArrayList<>();

        try {
            Ubicacion ubicacionSaved = ubicacionRepository.save(ubicacion);
            if (ubicacionSaved != null) {
                list.add(ubicacionSaved);
                response.getUbicacionResponse().setUbicaciones(list);
                response.setMetadata("Respuesta OK", "00", "Ubicación creada exitosamente");
            } else {
                response.setMetadata("Error", "-1", "No se pudo crear la ubicación");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al crear la ubicación");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<UbicacionResponseRest> updateUbicacion(Long id, Ubicacion ubicacion) {
        UbicacionResponseRest response = new UbicacionResponseRest();
        List<Ubicacion> list = new ArrayList<>();

        try {
            Ubicacion ubicacionExistente = ubicacionRepository.findById(id).orElse(null);
            if (ubicacionExistente != null) {
                ubicacionExistente.setTipoUbicacion(ubicacion.getTipoUbicacion());
                ubicacionExistente.setArea(ubicacion.getArea());
                ubicacionExistente.setBecario(ubicacion.getBecario());
                Ubicacion updatedUbicacion = ubicacionRepository.save(ubicacionExistente);
                list.add(updatedUbicacion);
                response.getUbicacionResponse().setUbicaciones(list);
                response.setMetadata("Respuesta OK", "00", "Ubicación actualizada exitosamente");
            } else {
                response.setMetadata("Error", "-1", "Ubicación no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar la ubicación");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<UbicacionResponseRest> deleteUbicacion(Long id) {
        UbicacionResponseRest response = new UbicacionResponseRest();

        try {
            ubicacionRepository.deleteById(id);
            response.setMetadata("Respuesta OK", "00", "Ubicación eliminada exitosamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar la ubicación");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
