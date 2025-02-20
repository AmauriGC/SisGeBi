package com.sisgebi.service;

import com.sisgebi.entity.Modelo;
import com.sisgebi.repository.ModeloRepository;
import com.sisgebi.response.ModeloResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<ModeloResponseRest> getAllModelos() {
        ModeloResponseRest response = new ModeloResponseRest();
        List<Modelo> modelos = new ArrayList<>();

        try {
            modelos = modeloRepository.findAll();
            response.getModeloResponse().setModelos(modelos);
            response.setMetadata("Respuesta OK", "00", "Consulta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta FALLIDA", "-1", "Error al consultar los modelos");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ModeloResponseRest> getModeloByNombre(String nombreModelo) {
        ModeloResponseRest response = new ModeloResponseRest();
        List<Modelo> list = new ArrayList<>();

        try {
            Modelo modelo = modeloRepository.findByNombreModelo(nombreModelo);
            if (modelo != null) {
                list.add(modelo);
                response.getModeloResponse().setModelos(list);
                response.setMetadata("Respuesta OK", "00", "Modelo encontrado");
            } else {
                response.setMetadata("Respuesta No Encontrada", "-1", "Modelo no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al consultar el modelo");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ModeloResponseRest> createModelo(Modelo modelo) {
        ModeloResponseRest response = new ModeloResponseRest();
        List<Modelo> list = new ArrayList<>();

        try {
            modelo.setCreatedAt(LocalDateTime.now());
            modelo.setUpdatedAt(LocalDateTime.now());
            Modelo modeloSaved = modeloRepository.save(modelo);
            if (modeloSaved != null) {
                list.add(modeloSaved);
                response.getModeloResponse().setModelos(list);
                response.setMetadata("Respuesta OK", "00", "Modelo creado exitosamente");
            } else {
                response.setMetadata("Error", "-1", "No se pudo crear el modelo");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al crear el modelo");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<ModeloResponseRest> updateModelo(String nombreModelo, Modelo modelo) {
        ModeloResponseRest response = new ModeloResponseRest();

        try {
            Modelo existingModelo = modeloRepository.findByNombreModelo(nombreModelo);

            if (existingModelo == null) {
                response.setMetadata("Error", "-1", "Modelo no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            existingModelo.setNombreModelo(modelo.getNombreModelo());
            existingModelo.setFoto(modelo.getFoto());
            existingModelo.setStatus(modelo.getStatus());
            existingModelo.setMarca(modelo.getMarca());
            existingModelo.setUpdatedAt(LocalDateTime.now());

            modeloRepository.save(existingModelo);

            response.getModeloResponse().setModelos(List.of(existingModelo));
            response.setMetadata("Actualización Exitosa", "00", "Modelo actualizado correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar el modelo");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ModeloResponseRest> deleteModelo(String nombreModelo) {
        ModeloResponseRest response = new ModeloResponseRest();

        try {
            Modelo modelo = modeloRepository.findByNombreModelo(nombreModelo);

            if (modelo == null) {
                response.setMetadata("Error", "-1", "Modelo no encontrado");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            modeloRepository.delete(modelo);

            response.setMetadata("Eliminación Exitosa", "00", "Modelo eliminado correctamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar el modelo");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
