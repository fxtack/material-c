package com.fxtack.materialc.service.impl;

import com.fxtack.materialc.entity.LoginUser;
import com.fxtack.materialc.mapper.LoginUserMapper;
import com.fxtack.materialc.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户操作业务实现
 *
 * @author fxtack
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class LoginUserServiceImpl implements LoginUserService {

    private static final String LOGIN_USER_CACHE_NAME = "loginUser";

    @Autowired
    private LoginUserMapper userMapper;

    @Override
    @Cacheable(value = LOGIN_USER_CACHE_NAME, key = "'findById'+#id")
    public LoginUser findById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(value = LOGIN_USER_CACHE_NAME, key = "'findByName'+#userName")
    public LoginUser findByName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    @Override
    public List<LoginUser> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public void deleteById(int id) {
        userMapper.deleteByPrimary(id);
    }

    @Override
    @CacheEvict(value = LOGIN_USER_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void updateByIdSelective(LoginUser loginUser) {
        userMapper.updateByPrimaryKeySelective(loginUser);
    }

    @Override
    public void updateRoleById(int id, String roles) {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(id);
        loginUser.setRoles(roles);
        userMapper.updateByPrimaryKeySelective(loginUser);
    }

    @Override
    public void save(LoginUser loginUser) {
        userMapper.insert(loginUser);
    }
}