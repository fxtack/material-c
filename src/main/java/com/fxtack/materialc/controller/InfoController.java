package com.fxtack.materialc.controller;

import com.fxtack.materialc.entity.LoginUser;
import com.fxtack.materialc.service.LoginUserService;
import com.fxtack.materialc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * 个人信息界面控制器
 *
 * @author fxtack
 */
@Controller
public class InfoController {

    @Autowired
    LoginUserService loginUserService;

    @RequestMapping("/getInfo")
    @ResponseBody
    JsonResult getInfo() {
        LoginUser user = loginUserService.findByName(getUserName());
        return new JsonResult(true, "" , user);
    }

    @PostMapping("/updateInfo")
    @ResponseBody
    JsonResult updateInfo(
            @RequestParam String name,
            @RequestParam String autograph
    ) {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(loginUserService.findByName(getUserName()).getId());
        loginUser.setUserName(name);
        loginUser.setUserAutograph(autograph);
        loginUserService.updateByIdSelective(loginUser);
        return new JsonResult(true, "");
    }

    @PostMapping("/updateOtherInfo")
    @ResponseBody
    JsonResult updateInfo(
            @RequestParam String name,
            @RequestParam String sex,
            @RequestParam String area,
            @RequestParam String address,
            @RequestParam String contact,
            @RequestParam String email
    ) {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(loginUserService.findByName(getUserName()).getId());
        loginUser.setUserName(name);
        loginUser.setUserSex((sex.equals("男") ? 1 : 0));
        loginUser.setArea(area);
        loginUser.setUserAddress(address);
        loginUser.setUserContact(contact);
        loginUser.setUserEmail(email);
        loginUserService.updateByIdSelective(loginUser);
        return new JsonResult(true, "");
    }

    private String getUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name;
        if (principal instanceof UserDetails) {
            name = ((UserDetails) principal).getUsername();
        }else if (principal instanceof Principal) {
            name = ((Principal) principal).getName();
        }else {
            name = String.valueOf(principal);
        }
        return name;
    }
}
