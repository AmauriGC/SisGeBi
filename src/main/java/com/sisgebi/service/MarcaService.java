package com.sisgebi.service;

import com.sisgebi.entity.Marca;
import com.sisgebi.repository.MarcaRepository;
import com.sisgebi.response.MarcaResponseRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<MarcaResponseRest> getAllMarcas() {
        MarcaResponseRest response = new MarcaResponseRest();
        List<Marca> marcas = new ArrayList<>();

        try {
            marcas = marcaRepository.findAll();
            response.getMarcaResponse().setMarcas(marcas);
            response.setMetadata("Respuesta OK", "00", "Consulta exitosa");
        } catch (Exception e) {
            response.setMetadata("Respuesta FALLIDA", "-1", "Error al consultar las marcas");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<MarcaResponseRest> getMarcaById(Long id) {
        MarcaResponseRest response = new MarcaResponseRest();
        List<Marca> list = new ArrayList<>();

        try {
            Marca marca = marcaRepository.findById(id).orElse(null);
            if (marca != null) {
                list.add(marca);
                response.getMarcaResponse().setMarcas(list);
                response.setMetadata("Respuesta OK", "00", "Marca encontrada");
            } else {
                response.setMetadata("Respuesta No Encontrada", "-1", "Marca no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al consultar la marca");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<MarcaResponseRest> createMarca(Marca marca) {
        MarcaResponseRest response = new MarcaResponseRest();
        List<Marca> list = new ArrayList<>();

        try {
            Marca marcaSaved = marcaRepository.save(marca);
            if (marcaSaved != null) {
                list.add(marcaSaved);
                response.getMarcaResponse().setMarcas(list);
                response.setMetadata("Respuesta OK", "00", "Marca creada exitosamente");
            } else {
                response.setMetadata("Error", "-1", "No se pudo crear la marca");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al crear la marca");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<MarcaResponseRest> updateMarca(Long id, Marca marca) {
        MarcaResponseRest response = new MarcaResponseRest();
        List<Marca> list = new ArrayList<>();

        try {
            Marca marcaExistente = marcaRepository.findById(id).orElse(null);
            if (marcaExistente != null) {
                marcaExistente.setNombreMarca(marca.getNombreMarca());
                marcaExistente.setStatus(marca.getStatus());
                Marca updatedMarca = marcaRepository.save(marcaExistente);
                list.add(updatedMarca);
                response.getMarcaResponse().setMarcas(list);
                response.setMetadata("Respuesta OK", "00", "Marca actualizada exitosamente");
            } else {
                response.setMetadata("Error", "-1", "Marca no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al actualizar la marca");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<MarcaResponseRest> deleteMarca(Long id) {
        MarcaResponseRest response = new MarcaResponseRest();

        try {
            marcaRepository.deleteById(id);
            response.setMetadata("Respuesta OK", "00", "Marca eliminada exitosamente");
        } catch (Exception e) {
            response.setMetadata("Error", "-1", "Error al eliminar la marca");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
