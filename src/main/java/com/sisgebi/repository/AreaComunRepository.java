package com.sisgebi.repository;

import com.sisgebi.entity.AreaComun;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaComunRepository extends MongoRepository<AreaComun, String> {
    AreaComun findByNombreArea(String nombreArea);  // Busca área por nombre
}
