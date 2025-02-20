package com.sisgebi.repository;

import com.sisgebi.entity.Becario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BecarioRepository extends MongoRepository<Becario, String> {
    Becario findByUsuario(String usuario);  // Busca becario por nombre de usuario
}
