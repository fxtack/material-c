package com.fxtack.materialc.mapper;

import com.fxtack.materialc.entity.InviteCode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InviteCodeMapper {
    List<InviteCode> selectAll();

    InviteCode selectByPrimaryKey(Integer id);

    InviteCode selectByValue(String inviteValue);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InviteCode inviteCode);

    int insertSelective(InviteCode inviteCode);

    int insert(InviteCode inviteCode);
}
