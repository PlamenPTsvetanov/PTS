package com.project.pts.views.out;

import com.project.pts.entities.OffDayEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class OffDayOutView {
    private String actualDate;
    private String creator;

    @Enumerated(EnumType.STRING)
    private OffDayEnum type;

    private String reasoning;

    private String color;


    public OffDayOutView() {
    }

    public OffDayOutView(String actualDate, String creator, OffDayEnum type, String reasoning, String color) {
        this.actualDate = actualDate;
        this.creator = creator;
        this.type = type;
        this.reasoning = reasoning;
        this.color = color;
    }


    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
