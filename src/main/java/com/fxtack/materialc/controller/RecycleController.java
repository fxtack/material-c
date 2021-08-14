package com.fxtack.materialc.controller;

import com.fxtack.materialc.entity.Material;
import com.fxtack.materialc.service.MaterialService;
import com.fxtack.materialc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 回收站界面控制器
 *
 * @author fxtack
 */
@Controller
public class RecycleController {

    @Autowired
    MaterialService materialService;

    @RequestMapping("/getDeleteFile")
    @ResponseBody
    public JsonResult getDeleteFile(@RequestParam int pathId) {
        List<Material> list = materialService.findAllDelete();
        System.out.println(list);
        return new JsonResult(true, "成功", list);
    }

    @RequestMapping("/deleteSearch")
    @ResponseBody
    public JsonResult deleteSearch(@RequestParam String searchWord) {
        List<Material> list = materialService.searchNameFromDelete(searchWord);
        return new JsonResult(true, "成功", list);
    }
}
