package com.project.pts.views.out;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskOutView {
    private String name;
    private String description;
    private String start;
    private String end;

    @JsonProperty("creator")
    private UserOutView user;

    public TaskOutView() {

    }

    public TaskOutView(String name,
                       String description,
                       String start,
                       String end,
                       UserOutView user) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public UserOutView getUser() {
        return user;
    }

    public void setUser(UserOutView user) {
        this.user = user;
    }
}
