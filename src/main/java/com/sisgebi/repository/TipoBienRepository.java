package com.sisgebi.repository;

import com.sisgebi.entity.TipoBien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoBienRepository extends JpaRepository<TipoBien, Long> {
}
