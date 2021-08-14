package com.fxtack.materialc.service;

import com.fxtack.materialc.entity.format.FormatDeleteMessage;

import java.util.List;

public interface DeleteMessageService {
    List<FormatDeleteMessage> findAll();

    void clearAll();

    void multipleInsert(List<FormatDeleteMessage> list);
}
