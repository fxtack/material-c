package com.fxtack.materialc.service.impl;

import com.fxtack.materialc.entity.LoginUser;
import com.fxtack.materialc.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * spring security 根据数据库用户信息进行验证的业务实现
 *
 * @author fxtack
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    LoginUserService loginUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LoginUser user = loginUserService.findByName(s);
        if(user == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+user.getRoles());
        return new User(user.getUserName(), new BCryptPasswordEncoder().encode(user.getUserPassword()), auths);
    }
}
