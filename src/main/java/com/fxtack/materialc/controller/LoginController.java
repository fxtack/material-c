package com.fxtack.materialc.controller;

import cn.hutool.core.date.DateUtil;
import com.fxtack.materialc.entity.LoginUser;
import com.fxtack.materialc.service.InviteCodeService;
import com.fxtack.materialc.service.LoginUserService;
import com.fxtack.materialc.util.JsonResult;
import org.apache.tomcat.util.net.jsse.JSSEImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * 登录控制器 spring security 切面控制
 *
 * @author fxtack
 */
@Controller
public class LoginController {

    @Autowired
    LoginUserService loginUserService;

    @Autowired
    InviteCodeService inviteCodeService;

    @GetMapping("/user/login")
    String login() {
        return "security/login";
    }

    @GetMapping("/user/register")
    String register() {
        return "security/register";
    }

    @GetMapping("/user/resetPassword")
    String resetPassword() {
        return "security/reset_password";
    }

    @PostMapping("/user/verifyRegister")
    @ResponseBody
    JsonResult verifyRegister(@RequestParam String name, @RequestParam String password, @RequestParam String invite) {
        if(loginUserService.findByName(name) != null){
            return new JsonResult(false, "用户名已存在");
        };
        if(!inviteCodeService.verifyInvite(invite)) {
            return new JsonResult(false, "邀请码不存在或已过期");
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setRoles("staff");
        loginUser.setUserName(name);
        loginUser.setUserPassword(password);
        loginUser.setUserCreateDate(DateUtil.date().toString());
        loginUser.setUserInvite(invite);
        loginUserService.save(loginUser);
        return new JsonResult(true, "");
    }

    @PostMapping("/user/resetPassword")
    @ResponseBody
    JsonResult resetPassword(@RequestParam String name, @RequestParam String password,@RequestParam String newPassword) {
        LoginUser loginUser = loginUserService.findByName(name);
        if(!loginUser.getUserPassword().equals(password)) {
            return new JsonResult(false, "用户名或密码错误");
        }
        loginUser.setUserPassword(newPassword);
        loginUserService.updateByIdSelective(loginUser);
        return new JsonResult(true, "");
    }
}
