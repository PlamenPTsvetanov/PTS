package com.project.pts.views.in;

import com.project.pts.entities.OffDayEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class OffDayInView {

    private String actualDate;

    private String type;

    private String reasoning;

    private Long userId;

    public OffDayInView() {
    }

    public OffDayInView(String actualDate, Long userId, String type, String reasoning) {
        this.actualDate = actualDate;
        this.userId = userId;
        this.type = type;
        this.reasoning = reasoning;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getActualDate() {
        return actualDate;
    }

    public void setActualDate(String actualDate) {
        this.actualDate = actualDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReasoning() {
        return reasoning;
    }

    public void setReasoning(String reasoning) {
        this.reasoning = reasoning;
    }
}
