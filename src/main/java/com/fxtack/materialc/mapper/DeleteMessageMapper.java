package com.fxtack.materialc.mapper;

import com.fxtack.materialc.entity.format.FormatDeleteMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DeleteMessageMapper {
    List<FormatDeleteMessage> selectAll();

    int deleteAll();

    int multipleInsert(List<FormatDeleteMessage> list);
}
