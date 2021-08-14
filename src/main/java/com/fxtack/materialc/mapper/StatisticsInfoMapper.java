package com.fxtack.materialc.mapper;

import com.fxtack.materialc.entity.StatisticsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO 接口
 * 数据库表: global_statistics
 * entity: StatisticsInfo
 *
 * @author fxtack
 */
@Repository
@Mapper
public interface StatisticsInfoMapper {

    StatisticsInfo selectByFileType(String typeName);

    List<StatisticsInfo> selectAll();

    Integer selectSumNumber();

    Long selectSumSize();
}
