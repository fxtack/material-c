package com.fxtack.materialc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 主界面左侧边栏跳转控制器
 *
 * @author fxtack
 */
@RequestMapping(value = "/main")
@Controller
public class MainController {

    @GetMapping
    public String mainIndex(){ return "main/index"; }

    //localhost:8005/main/
    @GetMapping("/")
    public String index() {
        return "main/index";
    }

    //localhost:8005/main/files
    @GetMapping("/files")
    public String file() {
        return "main/file_test";
    }

    //localhost:8005/main/info
    @GetMapping("/info")
    public String info() {
        return "main/info";
    }

    @GetMapping("/setting")
    public String setting() {
        return "main/setting";
    }

    @GetMapping("/task")
    public String plan() {
        return "main/task";
    }

    @GetMapping("/project")
    public String project() {
        return "main/project";
    }

    @GetMapping("/favour")
    public String materialFavour(Model model) {
//        model.addAttribute("folder_id", 1);
        return "main/file_favours";
    }

    @GetMapping("/material_view")
    public String materialView() {
        return "main/material_view";
    }

    @GetMapping("/recycle")
    public String recycle() {
        return "main/file_delete";
    }
}
