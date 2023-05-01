package com.project.pts.repositories;

import com.project.pts.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query(value = "select * from tasks t where t.user_id = :userId order by t.inserted_at desc", nativeQuery = true)
    List<TaskEntity> getLatestActivities(Long userId);
}
