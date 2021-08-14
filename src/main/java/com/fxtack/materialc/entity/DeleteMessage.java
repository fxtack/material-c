package com.fxtack.materialc.entity;

import com.fxtack.materialc.entity.Material;
import java.util.Date;

/**
 * DeleteThread 中素材删除队列中的删除记录类
 *
 * @author fxtack
 */
public class DeleteMessage {

    private String filePath;
    private Date beginTime;
    private Date endTime;

    public DeleteMessage(String filePath) {
        this.filePath = filePath;
        this.beginTime = new Date();
    }

    public DeleteMessage(Material material) {
        this.filePath = System.getProperties().getProperty("user.home") + "/material"+material.getPicturePath();
        this.beginTime = new Date();
    }

    public DeleteMessage() {
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "DeleteMessage{" +
                "filePath='" + filePath + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }
}
