package com.fxtack.materialc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 根路径转换控制器
 *
 * @author fxtack
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String test() {
        return "redirect:/main/";
    }
}
