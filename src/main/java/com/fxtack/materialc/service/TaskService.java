package com.fxtack.materialc.service;

import com.fxtack.materialc.entity.format.FormatTask;
import com.fxtack.materialc.entity.Task;

import java.util.List;

/**
 * 任务操作业务接口
 *
 * @author fxtack
 */
public interface TaskService {

    List<FormatTask> findAll();

    FormatTask findById(int id);

    List<Integer> countTag();

    void addTask(Task task);

    void updateById(Task task);

    void deleteById(int id);
}
