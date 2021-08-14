package com.fxtack.materialc.mapper;

import com.fxtack.materialc.entity.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO 接口
 * 数据库表: login_user
 * entity: LoginUser
 *
 * @author fxtack
 */
@Repository
@Mapper
public interface LoginUserMapper {

    LoginUser selectByPrimaryKey(Integer key);

    LoginUser selectByUserName(String userName);

    List<LoginUser> selectAll();

    int deleteByPrimary(Integer id);

    int updateByPrimaryKeySelective(LoginUser loginUser);

    int insert(LoginUser loginUser);
}
