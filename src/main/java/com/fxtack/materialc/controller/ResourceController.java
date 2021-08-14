package com.fxtack.materialc.controller;

import cn.hutool.core.date.DateUtil;
import com.fxtack.materialc.entity.Material;
import com.fxtack.materialc.entity.VirtualFolder;
import com.fxtack.materialc.entity.format.FormatVirtualFolder;
import com.fxtack.materialc.service.MaterialService;
import com.fxtack.materialc.service.VirtualService;
import com.fxtack.materialc.thread.DeleteThread;
import com.fxtack.materialc.entity.DeleteMessage;
import com.fxtack.materialc.util.JsonResult;
import com.fxtack.materialc.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 相关资源控制器
 *
 * @author fxtack
 */
@Controller
public class ResourceController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private VirtualService virtualService;

    @Autowired
    private DeleteThread deleteThread;

    @PostMapping("/getMaterialC")
    @ResponseBody
    public JsonResult getMaterialC() {
        return new JsonResult(true, "", virtualService.findInnerFolder(1));
    }

    @RequestMapping("/getFolderFile")
    @ResponseBody
    public JsonResult getFile(@RequestParam int pathId) {
        VirtualFolder folder = virtualService.findById(pathId);
        if(folder == null) {
            return new JsonResult(false, "失败");
        }

        List<Material> list = materialService.findByPathIdNoDelete(pathId);
        List<FormatVirtualFolder> list2 = virtualService.findInnerFolder(pathId);
        if(list2 != null)list2.stream().forEach(e->list.add(e));
        // 格式化大小
//        list.stream().forEach(obj->obj.parseSize());
        return new JsonResult(true, "成功", list);
    }

    @RequestMapping("/addFolder")
    @ResponseBody
    public JsonResult addFolder(@RequestParam int belongId) {
        VirtualFolder folder = virtualService.findById(belongId);
        VirtualFolder newFolder = new VirtualFolder(
                null, "新建项目 " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()),
                new Date(), 0, "尚未统计",
                folder.getFolderAbsolute()+folder.getFolderName()+"/",
                "", "", folder.getAbsoluteFolderPathId()+belongId+";");
        virtualService.save(newFolder);
        virtualService.updateInnerFolder(belongId, folder.getInnerFolderId()+ newFolder.getId() +";");

        return new JsonResult(true, "", null);
    }

    @PostMapping("/getContent")
    @ResponseBody
    public JsonResult findMaterialFile(@RequestParam(value = "id") Integer id) {
        Material material = materialService.findById(id);
        if(material != null) {
            if(material.getRemark() == null || material.getRemark().trim().equals("")){
                material.setRemark("暂无备注");
            }
        }else {
            return new JsonResult(false, "Material no find");
        }
        return new JsonResult(true,"", material);
    }

    @PostMapping("/getFolder")
    @ResponseBody
    public JsonResult findFolder(@RequestParam(value = "id") int id) {
        VirtualFolder virtualFolder = virtualService.findById(id);
        if(virtualFolder != null) {
            if(virtualFolder.getFolderRemark() == null || virtualFolder.getFolderRemark().trim().equals("")){
                virtualFolder.setFolderRemark("暂无备注");
            }
        }else{
            return new JsonResult(false, "Folder no find");
        }
        return new JsonResult(true, "", virtualFolder);
    }

    @PostMapping("/search")
    @ResponseBody
    public JsonResult search(@RequestParam(value="pathId") int pathId, @RequestParam(value="searchWord") String searchWord) {
        List<Material> list = materialService.search(pathId, searchWord);
        return new JsonResult(true, "", list);
    }

    @PostMapping("/updateRemark")
    @ResponseBody
    public JsonResult updateRemark(@RequestParam(value = "isFile") boolean isFile,@RequestParam(value = "id")Integer id, @RequestParam(value = "newRemark")String newRemark) {
        if(isFile) {
            materialService.updateRemark(id, newRemark);
        }else {
            virtualService.updateRemark(id, newRemark);
        }
        return new JsonResult(true, "");
    }

    @PostMapping("/updateName")
    @ResponseBody
    public JsonResult updateName(@RequestParam(value = "isFile") boolean isFile,@RequestParam(value = "id")Integer id, @RequestParam(value = "newName")String newName) {
        if(isFile) {
            materialService.updateName(id, newName);
        }else {
            virtualService.updateName(id, newName);
        }
        return new JsonResult(true, "");
    }

    @PostMapping("/updateFavour")
    @ResponseBody
    public JsonResult updateFavour(@RequestParam(value = "isFile") boolean isFile,@RequestParam(value = "id")Integer id, @RequestParam(value = "isFavour")boolean isFavour) {
        if(isFile) {
            materialService.updateFavour(id, isFavour);
        }else {
            return new JsonResult(false, "");
        }
        return new JsonResult(true, "");
    }

    @PostMapping("/multipleUpdateFavour")
    @ResponseBody
    public JsonResult updateFavour(@RequestParam(value = "isFile") boolean isFile,@RequestParam(value = "id[]")Integer[] id, @RequestParam(value = "isFavour")boolean isFavour) {
        materialService.updateFavour(id, isFavour);
        return new JsonResult(true, "");
    }

    @PostMapping("/moveFile")
    @ResponseBody
    public JsonResult moveFile(@RequestParam(value="isFile") boolean isFile ,@RequestParam(value="id") Integer id, @RequestParam(value="pathId") Integer pathId) {
        if(isFile) {
            VirtualFolder virtualFolder = virtualService.findById(pathId);
            if(virtualFolder == null) {
                return new JsonResult(false, "ID 指定项目不存在");
            }
            materialService.updateVirtualPathId(id, pathId);
            return new JsonResult(true, "");
        }
        return new JsonResult(false ,"");
    }

    @PostMapping("/multipleMoveFile")
    @ResponseBody
    public JsonResult moveFile(@RequestParam(value="isFile") boolean isFile ,@RequestParam(value="id[]") Integer[] id, @RequestParam(value="pathId") Integer pathId) {
        VirtualFolder virtualFolder = virtualService.findById(pathId);
        if(virtualFolder == null) {
            return new JsonResult(false, "ID 指定项目不存在");
        }
        materialService.updateVirtualPathId(id, pathId);
        return new JsonResult(true, "");
    }

    @PostMapping("/copyFile")
    @ResponseBody
    public JsonResult copyFile(@RequestParam(value="isFile") boolean isFile ,@RequestParam(value="id") Integer id, @RequestParam(value="pathId") Integer pathId) {
        if(isFile) {
            VirtualFolder virtualFolder = virtualService.findById(pathId);
            if(virtualFolder == null) {
                return new JsonResult(false, "ID 指定项目不存在");
            }
            Material material = materialService.findByIdNoParseSize(id);
            material.setId(null);
            material.setVirtualPathId(pathId);
            materialService.save(material);
            return new JsonResult(true, "");
        }
        return new JsonResult(false, "");
    }

    @PostMapping("/multipleCopyFile")
    @ResponseBody
    public JsonResult copyFile(@RequestParam(value="isFile") boolean isFile ,@RequestParam(value="id[]") Integer[] id, @RequestParam(value="pathId") Integer pathId) {
        VirtualFolder virtualFolder = virtualService.findById(pathId);
        if(virtualFolder == null) {
            return new JsonResult(false, "ID 指定项目不存在");
        }
        materialService.save(materialService.findById(id).stream().map(e->{e.setId(null);e.setVirtualPathId(pathId);return e;}).collect(Collectors.toList()));
        return new JsonResult(true, "");
    }

    @PostMapping("/updateDelete")
    @ResponseBody
    public JsonResult updateDelete(@RequestParam(value = "isFile") boolean isFile,@RequestParam(value = "pathId") Integer pathId,@RequestParam(value = "id")Integer id, @RequestParam(value = "isDelete") boolean isDelete) {
        if(isFile) {
            materialService.updateDelete(id, isDelete);
            return new JsonResult(true, "");
        }else {
            if(materialService.findByPathId(id).isEmpty() && virtualService.findById(id).getInnerFolderId().equals("")){
                virtualService.deleteFolder(id);
                VirtualFolder virtualFolder = virtualService.findById(pathId);
                virtualFolder.setInnerFolderId(
                        Arrays.asList(virtualFolder.getInnerFolderId().split(";"))
                        .stream()
                                .filter(e->Integer.valueOf(e)!=id)
                                .reduce("", (a,c)->a+c+";")
                );
                virtualService.updateFolder(virtualFolder);
                return new JsonResult(true, "");
            }else {
                return new JsonResult(false, "项目中还存在素材, 无法直接删除");
            }
        }
    }

    @PostMapping("/multipleUpdateDelete")
    @ResponseBody
    public JsonResult multipleUpdateDelete(@RequestParam(value = "isFile") boolean isFile,@RequestParam(value = "pathId") Integer pathId,@RequestParam(value = "id[]")Integer[] id, @RequestParam(value = "isDelete") boolean isDelete) {
        materialService.updateDelete(id, isDelete);
        return new JsonResult(true, "");
    }


    @PostMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(value = "isFile") boolean isFile,@RequestParam(value = "id")Integer id) throws Exception {
        if(isFile) {
            if(deleteThread != null) {
                deleteThread.putDeleteMessage(new DeleteMessage(materialService.findById(id)));
            }
            materialService.deleteById(id);
            return new JsonResult(true,"");
        }
        return new JsonResult(false, "");
    }

    @PostMapping("/multipleDelete")
    @ResponseBody
    public JsonResult delete(@RequestParam(value = "isFile") boolean isFile,@RequestParam(value = "id[]")Integer[] id){
        if(deleteThread != null) {
            materialService.findById(id).stream().forEach(e->{
                deleteThread.putDeleteMessage(new DeleteMessage(e));
            });
        }
        materialService.deleteById(id);
        return new JsonResult(true, "");
    }

    @GetMapping("/main/file/{pathId}")
    public String folder(Model model, @PathVariable int pathId) {
        VirtualFolder folder = virtualService.findById(pathId);
        if(folder == null) {
            return "redirect:/error/404.html";
        }
        Map<Integer, String> pathMap = virtualService.findSerialPathInfoByPathId(pathId);
        model.addAttribute("path_map", pathMap);
        model.addAttribute("folder_id", pathId);
        model.addAttribute("folder_absolute", folder.getFolderAbsolute());
        model.addAttribute("folder_name", folder.getFolderName());
        return "main/file_test";
    }

    @RequestMapping(value="/upload/{id}")
    @ResponseBody
    public JsonResult upload(@PathVariable int id, @RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        return uploadFile(id, file, request);
    }

    public JsonResult uploadFile(int id, @RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            try {
                // 获取用户目录
                String userPath = System.getProperties().getProperty("user.home") + "/material/";
                // 保存目录
                StringBuffer hold = new StringBuffer("upload/");
                // 获取时间，以年月创建目录
                Date date = DateUtil.date();
                hold.append(DateUtil.thisYear()).append("/").append(DateUtil.thisMonth() + 1).append("/");
                File mediaPath = new File(userPath, hold.toString());
                // 如果没有该目录则创建
                if (!mediaPath.exists()) {
                    mediaPath.mkdirs();
                }
                System.out.println("素材已存储|路径:" + mediaPath);
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                // 生成文件名称
                String nameSuffix = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."))
                        .replaceAll(" ", "_").replaceAll(",", "") + format.format(DateUtil.date())
                        + new Random().nextInt(1000);
                // 文件后缀
                String fileSuffix = file.getOriginalFilename()
                        .substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                // 上传文件名加后缀
                String fileName = nameSuffix + "." + fileSuffix;

                // 转存文件
                file.transferTo(new File(mediaPath.toString(), fileName));

                // 原图片路径
                StringBuffer originalPath = new StringBuffer();
                originalPath.append(mediaPath.getAbsolutePath()).append("/").append(fileName);

                Material material = new Material();

                StringBuffer originalDataPath = new StringBuffer();
                originalDataPath.append("/").append(hold).append(fileName);

                /*
                StringBuffer compressDataPath = null;
                if(fileSuffix.equals("jpg") || fileSuffix.equals("png") || fileSuffix.equals("jpeg") || fileSuffix.equals("gif")) {
                    StringBuffer compressPath = new StringBuffer();
                    compressPath.append(mediaPath.getAbsolutePath()).append("/").append(nameSuffix).append("_small.")
                            .append(fileSuffix);
                    // 压缩图片
                    Thumbnails.of(originalPath.toString()).size(256, 256).keepAspectRatio(false).toFile(compressPath.toString());
                    // 原图数据库路径

                    // 压缩图数据库路径
                    compressDataPath = new StringBuffer();
                    compressDataPath.append("/").append(hold).append(nameSuffix).append("_small.").append(fileSuffix);

                    attachment.setPictureSmallPath(compressDataPath.toString());

                }*/
                if(fileSuffix.equals("jpg") || fileSuffix.equals("png") || fileSuffix.equals("jpeg") || fileSuffix.equals("gif")) {
                    material.setPictureWh(Util.getImageWh(new File(mediaPath.toString() + "/" + fileName)));
                }

                // 添加数据库
                material.setPictureName(file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")));
                material.setPicturePath(originalDataPath.toString());
                material.setPictureType(file.getContentType());
                material.setPictureCreateDate(date);
                material.setPictureSuffix(new StringBuffer().append(".").append(fileSuffix).toString());
                material.setPictureSize(new File(mediaPath.toString() + "/" + fileName).length()+"");
                material.setVirtualPathId(id);
                material.setRemark(" ");
                material.setIsFavour(0);
                material.setIsDelete(0);
                System.out.println(material);
                materialService.save(material);
            } catch (Exception e) {
                return new JsonResult(false, "系统未知错误");
            }
        } else {
            return new JsonResult(false, "文件不能为空");
        }
        return new JsonResult(true, "上传成功");
    }
}
