package com.fxtack.materialc.runner;

import com.fxtack.materialc.config.DeleteThreadConfig;
import com.fxtack.materialc.thread.DeleteThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 素材删除队列守护线程启动器
 *
 * @author fxtack
 */
@Component
public class DeleteThreadRunner implements ApplicationRunner {

    @Autowired
    DeleteThread deleteThread;

    @Autowired
    DeleteThreadConfig deleteThreadConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(deleteThreadConfig.isEnable()) {
            System.out.println("DELETE SECURITY THREAD WAS RUNNING!");
            deleteThread.start();
        }else {
            System.out.println("DELETE SECURITY THREAD WAS DISABLE!");
        }
    }
}
