package com.project.pts.views.out;


public class ActivityOutView {
    private Long taskId;

    private String message;

    private String createdOn;

    public ActivityOutView() {

    }

    public ActivityOutView(Long taskId, String message, String createdOn) {
        this.taskId = taskId;
        this.message = message;
        this.createdOn = createdOn;
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
