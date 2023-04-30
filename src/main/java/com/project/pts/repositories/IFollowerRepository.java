package com.project.pts.repositories;

import com.project.pts.entities.FollowerEntity;
import com.project.pts.entities.FollowerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowerRepository extends JpaRepository<FollowerEntity, FollowerId> {

    FollowerEntity getByUserIdAndFollowerId(Long userId, Long followedId);
}
