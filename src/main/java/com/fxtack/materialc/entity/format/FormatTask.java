package com.fxtack.materialc.entity.format;

import com.fxtack.materialc.entity.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 格式化任务类, 该类与数据库映射对象 Task 不同, 该类通过格式化 Task 对象使该类传输到前端时更容易使用
 *
 * @author fxtack
 */
public class FormatTask {
    private Integer id;
    private String taskTitle;
    private List<String> taskTag;
    private String taskDeadline;
    private String taskContent;
    private Map<String, String> taskAppendix;
    private String taskSponsor;
    private Integer isFinish;
    private Integer taskProjectId;

    private FormatTask() {}

    public static FormatTask buildFormatTask(Task task) {
        FormatTask formatTask = new FormatTask();
        formatTask.id = task.getId();
        formatTask.taskTitle = task.getTaskTitle();
        formatTask.taskDeadline = task.getTaskDeadline();
        formatTask.taskContent = task.getTaskContent();
        formatTask.taskSponsor = task.getTaskSponsor();
        formatTask.isFinish = task.getIsFinish();
        formatTask.taskProjectId = task.getTaskProjectId();
        formatTask.taskTag = Arrays.asList(task.getTaskTag().split("\\."));
        formatTask.taskAppendix = new HashMap<>();
        System.out.println(";"+task.getTaskAppendix()+";");
        if(!task.getTaskAppendix().equals("")) {
            Arrays.asList(task.getTaskAppendix().split(";")).stream().forEach(e->{
                String[] var = e.split("\\|");
                formatTask.taskAppendix.put(var[0], var[1]);

            });
        }
        return formatTask;
    }

    @Override
    public String toString() {
        return "FormatTask{" +
                "id=" + id +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskTag=" + taskTag +
                ", taskDeadline='" + taskDeadline + '\'' +
                ", taskContent='" + taskContent + '\'' +
                ", taskAppendix=" + taskAppendix +
                ", taskSponsor='" + taskSponsor + '\'' +
                ", isFinish=" + isFinish +
                ", taskProjectId=" + taskProjectId +
                '}';
    }

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

    public List<String> getTaskTag() {
        return taskTag;
    }

    public void setTaskTag(List<String> taskTag) {
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

    public Map<String, String> getTaskAppendix() {
        return taskAppendix;
    }

    public void setTaskAppendix(Map<String, String> taskAppendix) {
        this.taskAppendix = taskAppendix;
    }

    public String getTaskSponsor() {
        return taskSponsor;
    }

    public void setTaskSponsor(String taskSponsor) {
        this.taskSponsor = taskSponsor;
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
}
