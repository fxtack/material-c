package com.fxtack.materialc.service;

import com.fxtack.materialc.entity.LoginUser;

import java.util.List;

/**
 * 用户操作业务接口
 *
 * @author fxtack
 */
public interface LoginUserService {

    LoginUser findById(int id);

    LoginUser findByName(String userName);

    List<LoginUser> findAll();

    void deleteById(int id);

    void updateByIdSelective(LoginUser loginUser);

    void updateRoleById(int id, String roles);

    void save(LoginUser loginUser);
}