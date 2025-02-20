package com.sisgebi.service;

import com.sisgebi.entity.Responsable;
import com.sisgebi.repository.ResponsableRepository;
import com.sisgebi.response.ResponsableResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResponsableService {

    @Autowired
    private ResponsableRepository responsableRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<ResponsableResponseRest> getAllResponsables() {
        ResponsableResponseRest response = new ResponsableResponseRest();
        List<Responsable> responsables = new ArrayList<>();

        try {
            responsables = responsableRepository.findAll();
            response.getResponsableResponse().setResponsables(responsables);
            response.setMetadata("Respuesta OK", "00", "Consulta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta FALLIDA", "-1", "Error al consultar los responsables");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ResponsableResponseRest> getResponsableByUsuario(String usuario) {
        ResponsableResponseRest response = new ResponsableResponseRest();
        List<Responsable> list = new ArrayList<>();

        try {
            Responsable responsable = responsableRepository.findByUsuario(usuario);
            if (responsable != null) {
                list.add(responsable);
                response.getResponsableResponse().setResponsables(list);
                response.setMetadata("Respuesta OK", "00", "Responsable encontrado");
            } else {
                response.setMetadata("Respuesta No Encontrada", "-1", "Responsable no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al consultar el responsable");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ResponsableResponseRest> createResponsable(Responsable responsable) {
        ResponsableResponseRest response = new ResponsableResponseRest();
        List<Responsable> list = new ArrayList<>();

        try {
            responsable.setCreatedAt(LocalDateTime.now());
            responsable.setUpdatedAt(LocalDateTime.now());
            Responsable responsableSaved = responsableRepository.save(responsable);
            if (responsableSaved != null) {
                list.add(responsableSaved);
                response.getResponsableResponse().setResponsables(list);
                response.setMetadata("Respuesta OK", "00", "Responsable creado exitosamente");
            } else {
                response.setMetadata("Error", "-1", "No se pudo crear el responsable");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al crear el responsable");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<ResponsableResponseRest> updateResponsable(String usuario, Responsable responsable) {
        ResponsableResponseRest response = new ResponsableResponseRest();

        try {
            Responsable existingResponsable = responsableRepository.findByUsuario(usuario);

            if (existingResponsable == null) {
                response.setMetadata("Error", "-1", "Responsable no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            existingResponsable.setNombreCompleto(responsable.getNombreCompleto());
            existingResponsable.setContraseña(responsable.getContraseña());
            existingResponsable.setLugar(responsable.getLugar());
            existingResponsable.setStatus(responsable.getStatus());
            existingResponsable.setUpdatedAt(LocalDateTime.now());

            responsableRepository.save(existingResponsable);

            response.getResponsableResponse().setResponsables(List.of(existingResponsable));
            response.setMetadata("Actualización Exitosa", "00", "Responsable actualizado correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar el responsable");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ResponsableResponseRest> deleteResponsable(String usuario) {
        ResponsableResponseRest response = new ResponsableResponseRest();

        try {
            Responsable responsable = responsableRepository.findByUsuario(usuario);

            if (responsable == null) {
                response.setMetadata("Error", "-1", "Responsable no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            responsableRepository.delete(responsable);

            response.setMetadata("Eliminación Exitosa", "00", "Responsable eliminado correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar el responsable");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
