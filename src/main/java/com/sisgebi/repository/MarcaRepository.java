package com.sisgebi.repository;

import com.sisgebi.entity.Marca;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends MongoRepository<Marca, String> {
    Marca findByNombreMarca(String nombreMarca);  // Busca la marca por nombreMarca
}
