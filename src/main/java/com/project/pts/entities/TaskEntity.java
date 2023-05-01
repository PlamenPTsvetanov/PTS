package com.project.pts.entities;

import com.project.pts.common.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;
    @Column(name = "inserted_at")
    private String insertedAt;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "is_deleted")
    private boolean isDeleted;
    public TaskEntity() {};

    public TaskEntity(
                 String insertedAt,
                 UserEntity user,
                 String name,
                 String description,
                 String startDate,
                 String endTime )
    {
        this.insertedAt = insertedAt;
        this.user = user;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endTime;
        this.isDeleted = false;
    }

    public String getInsertedAt() { return this.insertedAt; }
    public void setInsertedAt( String insertedAt ) { this.insertedAt = insertedAt; }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getName() { return this.name; }
    public void setName( String name ) { this.name = name; }

    public String getDescription() { return this.description; }
    public void setDescription( String description ) { this.description = description; }

    public String getStartDate() { return this.startDate; }
    public void setStartDate(String startTime ) { this.startDate = startTime; }

    public String getEndDate() { return this.endDate; }
    public void setEndDate(String endTime ) { this.endDate = endTime; }

    public boolean getIsDeleted() { return this.isDeleted; }
    public void setIsDeleted( boolean isDeleted ) { this.isDeleted = isDeleted; }
}
