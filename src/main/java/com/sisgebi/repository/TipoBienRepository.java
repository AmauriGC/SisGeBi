package com.sisgebi.repository;

import com.sisgebi.entity.TipoBien;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoBienRepository extends MongoRepository<TipoBien, String> {
    TipoBien findByNombreTipoBien(String nombreTipoBien);  // Busca el tipo de bien por nombre
}
