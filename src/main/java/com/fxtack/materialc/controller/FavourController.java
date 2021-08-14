package com.fxtack.materialc.controller;

import com.fxtack.materialc.entity.Material;
import com.fxtack.materialc.service.MaterialService;
import com.fxtack.materialc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 收藏素材界面控制器
 *
 * @author fxtack
 */
@Controller
public class FavourController {

    @Autowired
    MaterialService materialService;

    @RequestMapping("/getFavourFile")
    @ResponseBody
    public JsonResult getFavourFile(@RequestParam int pathId) {
        List<Material> list = materialService.findAllFavour();
        return new JsonResult(true, "成功", list);
    }

    @RequestMapping("/favourSearch")
    @ResponseBody
    public JsonResult favourSearch(@RequestParam String searchWord) {
        List<Material> list = materialService.searchNameFromFavour(searchWord);
        return new JsonResult(true, "成功", list);
    }
}
