package com.fxtack.materialc.entity;

/**
 * 任务 entity
 *
 * @author fxtack
 */
public class Task {
    private Integer id;
    private String taskTitle;
    private String taskTag;
    private String taskDeadline;
    private String taskContent;
    private String taskAppendix;
    private String taskSponsor;
    private Integer isFinish;
    private Integer taskProjectId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskTag() {
        return taskTag;
    }

    public void setTaskTag(String taskTag) {
        this.taskTag = taskTag;
    }

    public String getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(String taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getTaskAppendix() {
        return taskAppendix;
    }

    public void setTaskAppendix(String taskAppendix) {
        this.taskAppendix = taskAppendix;
    }

    public String getTaskSponsor() {
        return taskSponsor;
    }

    public void setTaskSponsor(String sponsor) {
        this.taskSponsor = sponsor;
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    public Integer getTaskProjectId() {
        return taskProjectId;
    }

    public void setTaskProjectId(Integer taskProjectId) {
        this.taskProjectId = taskProjectId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskTag='" + taskTag + '\'' +
                ", taskDeadline='" + taskDeadline + '\'' +
                ", taskContent='" + taskContent + '\'' +
                ", taskAppendix='" + taskAppendix + '\'' +
                ", taskSponsor='" + taskSponsor + '\'' +
                ", isFinish=" + isFinish +
                ", taskProjectId=" + taskProjectId +
                '}';
    }
}
