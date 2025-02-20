package com.sisgebi.repository;

import com.sisgebi.entity.Responsable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableRepository extends MongoRepository<Responsable, String> {
    Responsable findByUsuario(String usuario);  // Busca responsable por nombre de usuario
}
