package com.project.pts.repositories;

import com.project.pts.entities.ActivityEntity;
import com.project.pts.entities.OffDayEntity;
import com.project.pts.entities.OffDayEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOffDayRepository extends JpaRepository<OffDayEntity, Long> {
}
