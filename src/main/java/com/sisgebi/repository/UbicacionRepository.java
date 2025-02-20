package com.sisgebi.repository;

import com.sisgebi.entity.Ubicacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbicacionRepository extends MongoRepository<Ubicacion, String> {

    // Buscar ubicaciones por tipo de ubicación ('AreaComun' o 'Becario')
    List<Ubicacion> findByTipoUbicacion(String tipoUbicacion);
}
