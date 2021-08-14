package com.fxtack.materialc.thread;

import com.fxtack.materialc.config.DeleteThreadConfig;
import com.fxtack.materialc.entity.DeleteMessage;
import com.fxtack.materialc.entity.format.FormatDeleteMessage;
import com.fxtack.materialc.service.DeleteMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 删除线程
 *
 * @author fxtack
 */
@Component
public class DeleteThread extends Thread {

    @Autowired
    DeleteThreadConfig deleteThreadConfig;

    @Autowired
    DeleteMessageService deleteMessageService;

    private Vector<DeleteMessage>  messageList;

    private static DeleteThread deleteThread;

    private int second = 0;
    private int minute = 0;
    private int hour = 0;
    private int day = 0;
    private int month = 0;
    private long polling = 10000L;

    @Override
    public void run() {
        while(true) {
            try {
                sleep(this.polling);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("RUN");
            System.out.println(messageList);
            deleteMessageService.clearAll();
            if(!messageList.isEmpty()){
                deleteMessageService.multipleInsert(
                        FormatDeleteMessage.toFormatDeleteMessage(
                                messageList
                                        .stream()
                                        .collect(Collectors.toList())
                        )
                );
            }
            for(int i = 0 ; i < messageList.size() ; i++) {
                if(messageList.get(i).getEndTime().before(new Date())){
                    System.out.println("Hello");
                    executeDelete(messageList.get(i));
                }
            }
        }
    }

//    public DeleteThread() {
//
//    }
    @PostConstruct
    public void init() {
        deleteThread = this;
        this.second = deleteThreadConfig.getSecond();
        this.minute = deleteThreadConfig.getMinute();
        this.hour = deleteThreadConfig.getHour();
        this.day = deleteThreadConfig.getDay();
        this.month = deleteThreadConfig.getMonth();
        this.polling = deleteThreadConfig.getPolling();
        messageList = new Vector<>();
        FormatDeleteMessage.toDeleteMessage(deleteMessageService.findAll()).stream().forEach(e->messageList.add(e));
        this.setDaemon(true);
        this.setName("DELETE SECURITY THREAD");
    }

    public void putDeleteMessage(DeleteMessage deleteMessage) {
        Date date = deleteMessage.getBeginTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, this.second);
        cal.add(Calendar.MINUTE, this.minute);
        cal.add(Calendar.HOUR, this.hour);
        cal.add(Calendar.DAY_OF_MONTH, this.day);
        cal.add(Calendar.MONTH, this.month);
        deleteMessage.setEndTime(cal.getTime());
        System.out.println(deleteMessage.getBeginTime()+","+deleteMessage.getEndTime());
        messageList.add(deleteMessage);
    }

    private void executeDelete(DeleteMessage message) {
        File file = new File(message.getFilePath());
        if(file.exists()) {
            file.delete();
            System.out.println("EXECUTE THE DELETE COMMAND, file is exits?:"+file.exists());
            if(!file.exists()) {
                messageList.remove(message);
            }
        }else {
            messageList.remove(message);
        }
    }
}
