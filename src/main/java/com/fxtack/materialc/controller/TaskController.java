package com.fxtack.materialc.controller;

import com.fxtack.materialc.entity.format.FormatTask;
import com.fxtack.materialc.entity.Task;
import com.fxtack.materialc.service.TaskService;
import com.fxtack.materialc.service.VirtualService;
import com.fxtack.materialc.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 任务界面控制器
 *
 * @author fxtack
 */
@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    VirtualService virtualService;

    @RequestMapping("/getAllTask")
    @ResponseBody
    JsonResult getAllTask() {
        return new JsonResult(true, "", taskService.findAll());
    }

    @RequestMapping("/getAllTag")
    @ResponseBody
    JsonResult getAllTag() {
        return new JsonResult(true, "", taskService.countTag());
    }

    @RequestMapping("/finishTask")
    @ResponseBody
    JsonResult finishTask(@RequestParam("id") int id) {
        Task task = new Task();
        task.setId(id);
        task.setIsFinish(1);
        taskService.updateById(task);
        return new JsonResult(true,"");
    }

    @RequestMapping("/deleteTask")
    @ResponseBody
    JsonResult deleteTask(@RequestParam("id") int id) {
        taskService.deleteById(id);
        return new JsonResult(true, "");
    }

    @RequestMapping("/getTaskById")
    @ResponseBody
    JsonResult getTaskById(@RequestParam("id") int id){
        FormatTask task = taskService.findById(id);
        if(task == null) {
            return new JsonResult(false, "无查找对象");
        }
        return new JsonResult(true, "", task);
    }

    @RequestMapping("/addTask")
    @ResponseBody
    JsonResult addTask(
            @RequestParam(value="title") String title,
            @RequestParam(value="tag") String tag,
            @RequestParam(value="deadline") String deadline,
            @RequestParam(value="content") String content,
            @RequestParam(value="appendix") String appendix,
            @RequestParam(value="projectId") Integer projectId
    ) throws ParseException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name;
        if (principal instanceof UserDetails) {
            name = ((UserDetails) principal).getUsername();
        }else if (principal instanceof Principal) {
            name = ((Principal) principal).getName();
        }else {
            name = String.valueOf(principal);
        }

        if(virtualService.findById(projectId) == null){
            return new JsonResult(false, "请输入已有项目的 id");
        }

        Task newTask = new Task();
        newTask.setTaskTitle(title);
        newTask.setTaskTag(tag);
        newTask.setTaskDeadline(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(deadline)));
        newTask.setTaskContent(content);
        newTask.setTaskAppendix(appendix);
        newTask.setTaskSponsor(name);
        newTask.setIsFinish(0);
        newTask.setTaskProjectId(projectId);
        taskService.addTask(newTask);
        return new JsonResult(true, "新建成功");
    }
}
