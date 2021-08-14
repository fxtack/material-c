package com.fxtack.materialc.controller;

import com.fxtack.materialc.entity.StatisticsInfo;
import com.fxtack.materialc.service.MaterialService;
import com.fxtack.materialc.service.StatisticsInfoService;
import com.fxtack.materialc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 统计界面控制器
 *
 * @author fxtack
 */
@Controller
public class StatisticsController {

    @Autowired
    StatisticsInfoService statisticsInfoService;

    @Autowired
    MaterialService materialService;

    @RequestMapping("/getStatisticsInfo")
    @ResponseBody
    public JsonResult getInfo() {
        List<StatisticsInfo> list = statisticsInfoService.findAll();
        Object[] result = {materialService.countAll(), materialService.countFavour(), materialService.countDelete(), list};
        return new JsonResult(true, "", result);
    }
}
