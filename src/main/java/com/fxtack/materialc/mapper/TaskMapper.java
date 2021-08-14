package com.fxtack.materialc.mapper;

import com.fxtack.materialc.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO 接口
 * 数据库表: task
 * entity: Task
 *
 * @author fxtack
 */
@Repository
@Mapper
public interface TaskMapper {

    List<Task> selectAll();

    Task selectByPrimaryKey(Integer id);

    Integer countTag(String tag);

    int insert(Task task);

    int updateByPrimaryKeySelective(Task task);

    int deleteByPrimaryKey(Integer id);

}
