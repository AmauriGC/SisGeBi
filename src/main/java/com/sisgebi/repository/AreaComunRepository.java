package com.sisgebi.repository;

import com.sisgebi.entity.AreaComun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaComunRepository extends JpaRepository<AreaComun, Long> {
}
