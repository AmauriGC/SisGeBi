package com.sisgebi.repository;

import com.sisgebi.entity.Becario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BecarioRepository extends JpaRepository<Becario, Long> {
}
