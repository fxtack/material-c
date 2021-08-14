package com.fxtack.materialc.service.impl;

import com.fxtack.materialc.entity.format.FormatDeleteMessage;
import com.fxtack.materialc.mapper.DeleteMessageMapper;
import com.fxtack.materialc.service.DeleteMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class DeleteMessageServiceImpl implements DeleteMessageService {

    @Autowired
    DeleteMessageMapper deleteMessageMapper;

    @Override
    public List<FormatDeleteMessage> findAll() {
        return deleteMessageMapper.selectAll();
    }

    @Override
    public void clearAll() {
        deleteMessageMapper.deleteAll();
    }

    @Override
    public void multipleInsert(List<FormatDeleteMessage> list) {
        deleteMessageMapper.multipleInsert(list);
    }
}
