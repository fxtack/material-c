package com.fxtack.materialc.entity.format;

import com.fxtack.materialc.entity.DeleteMessage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class FormatDeleteMessage {

    private Integer id;
    private String filePath;
    private String beginTime;
    private String endTime;

    public static DeleteMessage toDeleteMessage(FormatDeleteMessage formatDeleteMessage) {
        SimpleDateFormat f = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setFilePath(formatDeleteMessage.getFilePath());
        try {
            deleteMessage.setBeginTime(f.parse(formatDeleteMessage.getBeginTime()));
            deleteMessage.setEndTime(f.parse(formatDeleteMessage.getEndTime()));
        }catch (ParseException e){
            e.printStackTrace();
        }
        return deleteMessage;
    }

    public static List<DeleteMessage> toDeleteMessage(List<FormatDeleteMessage> formatDeleteMessages) {
        return formatDeleteMessages.stream().map(e->toDeleteMessage(e)).collect(Collectors.toList());
    }

    public static FormatDeleteMessage toFormatDeleteMessage(DeleteMessage deleteMessage) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FormatDeleteMessage formatDeleteMessage = new FormatDeleteMessage();
        formatDeleteMessage.setFilePath(deleteMessage.getFilePath());
        formatDeleteMessage.setBeginTime(f.format(deleteMessage.getBeginTime()));
        formatDeleteMessage.setEndTime(f.format(deleteMessage.getEndTime()));
        return formatDeleteMessage;
    }

    public static List<FormatDeleteMessage> toFormatDeleteMessage(List<DeleteMessage> deleteMessages){
        return deleteMessages.stream().map(e->toFormatDeleteMessage(e)).collect(Collectors.toList());
    }

    public FormatDeleteMessage(Integer id, String filePath, String beginTime, String endTime) {
        this.id = id;
        this.filePath = filePath;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public FormatDeleteMessage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "FormatDeleteMessage{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
