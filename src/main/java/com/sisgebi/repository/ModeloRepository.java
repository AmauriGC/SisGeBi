package com.sisgebi.repository;

import com.sisgebi.entity.Modelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends MongoRepository<Modelo, String> {
    Modelo findByNombreModelo(String nombreModelo);  // Busca el modelo por nombre
}
