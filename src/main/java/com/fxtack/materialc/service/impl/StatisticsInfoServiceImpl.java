package com.fxtack.materialc.service.impl;

import com.fxtack.materialc.entity.StatisticsInfo;
import com.fxtack.materialc.mapper.StatisticsInfoMapper;
import com.fxtack.materialc.service.StatisticsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 统计数据操作业务实现
 *
 * @author fxtack
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class StatisticsInfoServiceImpl implements StatisticsInfoService {

    private static final String STATISTICS_INFO_CACHE_NAME = "statisticsInfo";

    @Autowired
    StatisticsInfoMapper statisticsInfoMapper;

    @Override
    @Cacheable(value = STATISTICS_INFO_CACHE_NAME, key = "'findByFileType'+#typeName")
    public StatisticsInfo findByFileType(String typName) {
        return statisticsInfoMapper.selectByFileType(typName);
    }

    @Override
    @Cacheable(value = STATISTICS_INFO_CACHE_NAME, key = "'findAll'")
    public List<StatisticsInfo> findAll() {
        return statisticsInfoMapper.selectAll();
    }

    @Override
    @Cacheable(value = STATISTICS_INFO_CACHE_NAME, key = "'findSumNumber'")
    public Integer findSumNumber() {
        return statisticsInfoMapper.selectSumNumber();
    }

    @Override
    @Cacheable(value = STATISTICS_INFO_CACHE_NAME, key = "'findSumSize'")
    public Long findSumSize() {
        return statisticsInfoMapper.selectSumSize();
    }
}
