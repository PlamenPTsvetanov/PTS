package com.project.pts.entities;

import java.io.Serializable;

public class FollowerId implements Serializable {
    private Long userId;
    private Long followerId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }
}
