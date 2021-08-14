package com.fxtack.materialc.service.impl;

import com.fxtack.materialc.entity.format.FormatTask;
import com.fxtack.materialc.entity.Task;
import com.fxtack.materialc.mapper.TaskMapper;
import com.fxtack.materialc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 任务操作业务实现
 *
 * @author fxtack
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class TaskServiceImpl implements TaskService {

    private static final String TASK_CACHE_NAME = "task";

    @Autowired
    TaskMapper taskMapper;

    @Override
    @Cacheable(value = TASK_CACHE_NAME, key = "'findAll'")
    public List<FormatTask> findAll() {
        return taskMapper.selectAll().stream().map(e-> FormatTask.buildFormatTask(e)).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = TASK_CACHE_NAME, key = "'findById'+#id")
    public FormatTask findById(int id) {
        return FormatTask.buildFormatTask(taskMapper.selectByPrimaryKey(id));
    }

    @Override
    public List<Integer> countTag() {
        List<Integer> list = Arrays.asList(taskMapper.countTag("撰写文稿"),taskMapper.countTag("媒体后期"),
                taskMapper.countTag("任务安排"),taskMapper.countTag("作品交付"),taskMapper.countTag("素材收集"));
        return list;
    }

    @Override
    public void addTask(Task task) {
        taskMapper.insert(task);
    }

    @Override
    public void updateById(Task task) {
        taskMapper.updateByPrimaryKeySelective(task);
    }

    @Override
    public void deleteById(int id) {
        taskMapper.deleteByPrimaryKey(id);
    }
}
