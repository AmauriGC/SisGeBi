package com.sisgebi.repository;

import com.sisgebi.entity.HistoricoBien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoBienRepository extends JpaRepository<HistoricoBien, Long> {
}
