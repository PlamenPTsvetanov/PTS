package com.project.pts.entities;

import com.project.pts.common.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "off_days")
public class OffDayEntity extends BaseEntity {
    @Column(name = "actual_date", unique = true)
    private String actualDate;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private OffDayEnum type;

    @Column(name = "reasoning")
    private String reasoning;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;

    public OffDayEntity() {
    }

    public OffDayEntity(String actualDate, UserEntity user, OffDayEnum type, String reasoning) {
        this.actualDate = actualDate;
        this.user = user;
        this.type = type;
        this.reasoning = reasoning;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getActualDate() {
        return actualDate;
    }

    public void setActualDate(String actualDate) {
        this.actualDate = actualDate;
    }

    public OffDayEnum getType() {
        return type;
    }

    public void setType(OffDayEnum type) {
        this.type = type;
    }

    public String getReasoning() {
        return reasoning;
    }

    public void setReasoning(String reasoning) {
        this.reasoning = reasoning;
    }
}
