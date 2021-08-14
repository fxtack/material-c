package com.fxtack.materialc.service;

import com.fxtack.materialc.entity.InviteCode;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.util.List;

public interface InviteCodeService {
    List<InviteCode> findAll();

    InviteCode findById(int id);

    InviteCode findByValue(String inviteValue);

    boolean verifyInvite(String inviteValue);

    boolean verifyInviteOverdue(InviteCode inviteCode);

    void deleteById(int id);

    void updateByIdSelective(InviteCode inviteCode);

    void updateRemarkById(int id, String remark);

    void save(InviteCode inviteCode);
}
