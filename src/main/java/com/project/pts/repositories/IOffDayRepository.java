package com.project.pts.repositories;

import com.project.pts.entities.OffDayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOffDayRepository extends JpaRepository<OffDayEntity, Long> {
}
