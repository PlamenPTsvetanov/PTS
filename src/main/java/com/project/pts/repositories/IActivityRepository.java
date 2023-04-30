package com.project.pts.repositories;

import com.project.pts.entities.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface IActivityRepository extends JpaRepository<ActivityEntity, Long> {

    @Query(value = "select * from activities a where a.user_id = :userId order by a.created_on desc limit 1", nativeQuery = true)
    ActivityEntity getLatestActivity(Long userId);
}
