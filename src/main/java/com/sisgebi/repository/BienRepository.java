package com.sisgebi.repository;

import com.sisgebi.entity.Bien;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BienRepository extends MongoRepository<Bien, String> {
    Bien findByCodigo(String codigo);  // Busca Bien por código
}
