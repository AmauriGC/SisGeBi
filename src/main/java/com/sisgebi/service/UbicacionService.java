package com.sisgebi.service;

import com.sisgebi.entity.Ubicacion;
import com.sisgebi.repository.UbicacionRepository;
import com.sisgebi.response.UbicacionResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    public ResponseEntity<UbicacionResponseRest> getUbicacionesByTipo(String tipoUbicacion) {
        UbicacionResponseRest response = new UbicacionResponseRest();
        List<Ubicacion> ubicaciones = new ArrayList<>();

        try {
            ubicaciones = ubicacionRepository.findByTipoUbicacion(tipoUbicacion);  // Buscar por tipoUbicacion
            if (!ubicaciones.isEmpty()) {
                response.getUbicacionResponse().setUbicaciones(ubicaciones);
                response.setMetadata("Respuesta OK", "00", "Ubicaciones encontradas");
            } else {
                response.setMetadata("Respuesta No Encontrada", "-1", "No se encontraron ubicaciones para el tipo especificado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al consultar las ubicaciones por tipo");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<UbicacionResponseRest> createUbicacion(Ubicacion ubicacion) {
        UbicacionResponseRest response = new UbicacionResponseRest();
        List<Ubicacion> list = new ArrayList<>();

        try {
            // Setear las fechas de creación y actualización
            ubicacion.setCreatedAt(LocalDateTime.now());
            ubicacion.setUpdatedAt(LocalDateTime.now());

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
    public ResponseEntity<UbicacionResponseRest> updateUbicacion(String tipoUbicacion, Ubicacion ubicacion) {
        UbicacionResponseRest response = new UbicacionResponseRest();

        try {
            // Buscar la ubicación por tipoUbicacion
            List<Ubicacion> ubicaciones = ubicacionRepository.findByTipoUbicacion(tipoUbicacion);
            if (ubicaciones.isEmpty()) {
                response.setMetadata("Error", "-1", "Ubicación no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            // Asumimos que se actualiza solo la primera coincidencia
            Ubicacion existingUbicacion = ubicaciones.get(0);
            existingUbicacion.setTipoUbicacion(ubicacion.getTipoUbicacion());
            existingUbicacion.setAreaComun(ubicacion.getAreaComun());
            existingUbicacion.setBecario(ubicacion.getBecario());
            existingUbicacion.setStatus(ubicacion.getStatus());

            // Actualizar la fecha de modificación
            existingUbicacion.setUpdatedAt(LocalDateTime.now());

            ubicacionRepository.save(existingUbicacion);

            response.getUbicacionResponse().setUbicaciones(List.of(existingUbicacion));
            response.setMetadata("Actualización Exitosa", "00", "Ubicación actualizada correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar la ubicación");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<UbicacionResponseRest> deleteUbicacion(String tipoUbicacion) {
        UbicacionResponseRest response = new UbicacionResponseRest();

        try {
            // Buscar la ubicación por tipoUbicacion
            List<Ubicacion> ubicaciones = ubicacionRepository.findByTipoUbicacion(tipoUbicacion);
            if (ubicaciones.isEmpty()) {
                response.setMetadata("Error", "-1", "Ubicación no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            // Eliminar la primera coincidencia
            ubicacionRepository.delete(ubicaciones.get(0));

            response.setMetadata("Eliminación Exitosa", "00", "Ubicación eliminada correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar la ubicación");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
