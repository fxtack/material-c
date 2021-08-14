package com.fxtack.materialc.entity.format;

import com.fxtack.materialc.entity.Material;
import com.fxtack.materialc.entity.VirtualFolder;

/**
 * 该类将 VirtualFolder 对象抽象为一个 Material 对象, 使得前端可以将 VirtualFolder 对象与 Material 对象进行一视同仁的处理
 *
 * @author fxtack
 */
public class FormatVirtualFolder extends Material {

    public static FormatVirtualFolder buildFormatVirtualFolder(VirtualFolder virtualFolder) {
        FormatVirtualFolder formatVirtualFolder = new FormatVirtualFolder();
        formatVirtualFolder.id = virtualFolder.getId();
        formatVirtualFolder.pictureName = virtualFolder.getFolderName();
        formatVirtualFolder.picturePath = "/main/file/"+virtualFolder.getId();
        formatVirtualFolder.pictureType = "文件夹";
        formatVirtualFolder.pictureCreateDate = virtualFolder.getFolderCreateDate();
        formatVirtualFolder.pictureSize = virtualFolder.getFolderFileSize();
        formatVirtualFolder.pictureSuffix = ".folder";
        formatVirtualFolder.pictureWh = "";
        formatVirtualFolder.remark = virtualFolder.getFolderRemark();
        formatVirtualFolder.isFavour = 0;
        formatVirtualFolder.isDelete = 0;
        return formatVirtualFolder;
    }

}
