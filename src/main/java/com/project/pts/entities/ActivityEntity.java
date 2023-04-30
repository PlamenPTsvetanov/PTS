package com.project.pts.entities;

import com.project.pts.common.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "activities")
public class ActivityEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;

    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "created_on")
    private String createdOn;


    public ActivityEntity() {
    }

    public ActivityEntity(UserEntity user, String message, String createdOn) {
        this.user = user;
        this.message = message;
        this.createdOn = createdOn;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
