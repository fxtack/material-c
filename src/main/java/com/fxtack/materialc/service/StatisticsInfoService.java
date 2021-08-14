package com.fxtack.materialc.service;

import com.fxtack.materialc.entity.StatisticsInfo;

import java.util.List;

/**
 * 统计数据操作业务接口
 *
 * @author fxtack
 */
public interface StatisticsInfoService {

    StatisticsInfo findByFileType(String typName);

    List<StatisticsInfo> findAll();

    Integer findSumNumber();

    Long findSumSize();
}
