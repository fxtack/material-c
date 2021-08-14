package com.fxtack.materialc.service.impl;

import cn.hutool.core.date.DateUtil;
import com.fxtack.materialc.entity.InviteCode;
import com.fxtack.materialc.mapper.InviteCodeMapper;
import com.fxtack.materialc.service.InviteCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class InviteCodeServiceImpl implements InviteCodeService {

    @Autowired
    InviteCodeMapper inviteCodeMapper;

    @Override
    public List<InviteCode> findAll() {
        return inviteCodeMapper.selectAll();
    }

    @Override
    public InviteCode findById(int id) {
        return inviteCodeMapper.selectByPrimaryKey(id);
    }

    @Override
    public InviteCode findByValue(String inviteValue) {
        return inviteCodeMapper.selectByValue(inviteValue);
    }

    @Override
    public boolean verifyInvite(String inviteValue) {
        InviteCode inviteCode = inviteCodeMapper.selectByValue(inviteValue);
        SimpleDateFormat f = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        if(inviteCode != null) {
            try {
                if(f.parse(inviteCode.getInviteEndDate()).before(DateUtil.date())) {
                    inviteCode.setInviteStat(1);
                    inviteCodeMapper.updateByPrimaryKeySelective(inviteCode);
                    return false;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            inviteCode.setInviteUsedTimes(inviteCode.getInviteUsedTimes()+1);
            inviteCodeMapper.updateByPrimaryKeySelective(inviteCode);
            return true;
        }
        return false;
    }

    // 该方法的输入 inviteCode 不会在数据库与缓存中回查。若未存储对应 inviteCode 记录，inviteCodeMapper抛出的异常直接被捕获处理
    @Override
    public boolean verifyInviteOverdue(InviteCode inviteCode) {
        SimpleDateFormat f = new SimpleDateFormat("yy-MM-dd HH:mm");
        try {
            if(f.parse(inviteCode.getInviteEndDate()).before(DateUtil.date())) {
                inviteCode.setInviteStat(1);
                inviteCodeMapper.updateByPrimaryKeySelective(inviteCode);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void deleteById(int id) {
        inviteCodeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateByIdSelective(InviteCode inviteCode) {
        inviteCodeMapper.updateByPrimaryKeySelective(inviteCode);
    }

    @Override
    public void updateRemarkById(int id, String remark) {
        InviteCode inviteCode = new InviteCode();
        inviteCode.setId(id);
        inviteCode.setInviteRemark(remark);
        inviteCodeMapper.updateByPrimaryKeySelective(inviteCode);
    }

    @Override
    public void save(InviteCode inviteCode) {
        inviteCodeMapper.insert(inviteCode);
    }
}
