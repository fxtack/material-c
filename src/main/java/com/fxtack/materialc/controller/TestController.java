package com.fxtack.materialc.controller;

import com.fxtack.materialc.entity.Material;
import com.fxtack.materialc.entity.LoginUser;
import com.fxtack.materialc.service.MaterialService;
import com.fxtack.materialc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目功能测试相关控制器
 *
 * @author fxtack
 */
@RequestMapping(value = "/t")
@Controller
public class TestController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public String index2() {
        return "test";
    }
    
    @PostMapping("/test/ajax")
    @ResponseBody
    public JsonResult test(@RequestParam(value = "id") String content) {
        System.out.println(content);
        return new JsonResult(true, " Hello Ajax "+content);
    }

    @GetMapping("/test")
    public String index(Model model) {
//        List<User> userList = userService.getAllUser();
        model.addAttribute("list", new LoginUser());
        model.addAttribute("var", 10);
        return "test";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public JsonResult test2(@RequestParam int id) {
        List<Material> list = materialService.findByPathId(1);
        return new JsonResult(true, "成功", list);
    }
}
