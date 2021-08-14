package com.fxtack.materialc.controller;

import cn.hutool.core.date.DateUtil;
import com.fxtack.materialc.entity.InviteCode;
import com.fxtack.materialc.service.InviteCodeService;
import com.fxtack.materialc.service.LoginUserService;
import com.fxtack.materialc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class SettingController {
    @Autowired
    LoginUserService loginUserService;

    @Autowired
    InviteCodeService inviteCodeService;

    @PostMapping("/getAllLoginUser")
    @ResponseBody
    JsonResult getUserList() {
        return new JsonResult(true, "", loginUserService.findAll());
    }

    @PostMapping("/getAllInviteCode")
    @ResponseBody
    JsonResult getAllInvite() {
        inviteCodeService.findAll().stream().forEach(e->inviteCodeService.verifyInviteOverdue(e));
        return new JsonResult(true, "", inviteCodeService.findAll());
    }

    @PostMapping("/addInviteCode")
    @ResponseBody
    JsonResult addInviteCode(@RequestParam String inviteEndDate, @RequestParam String inviteRemark) throws ParseException {
        InviteCode inviteCode = new InviteCode();
        inviteCode.setInviteRemark(inviteRemark);
        inviteCode.setInviteValue(((int)(Math.random()*1000000))+"");
        inviteCode.setInviteCreateDate(DateUtil.date().toString());
        inviteCode.setInviteEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(inviteEndDate)));
        inviteCodeService.save(inviteCode);
        return new JsonResult(true, "");
    }

    @PostMapping("/deleteInviteCode")
    @ResponseBody
    JsonResult deleteInviteCode(@RequestParam int id) {
        inviteCodeService.deleteById(id);
        return new JsonResult(true, "");
    }

    @PostMapping("/updateInviteCodeRemark")
    @ResponseBody
    JsonResult updateInviteCodeRemark( @RequestParam int id, @RequestParam String inviteRemark) {
        inviteCodeService.updateRemarkById(id, inviteRemark);
        return new JsonResult(true, "");
    }

    @PostMapping("/deleteLoginUser")
    @ResponseBody
    JsonResult deleteLoginUser(@RequestParam int id) {
        loginUserService.deleteById(id);
        return new JsonResult(true, "");
    }

    @PostMapping("/updateLoginUserRoles")
    @ResponseBody
    JsonResult updateLoginUserRoles(@RequestParam int id, @RequestParam String roles) {
        loginUserService.updateRoleById(id, roles);
        return new JsonResult(true, "");
    }
}
