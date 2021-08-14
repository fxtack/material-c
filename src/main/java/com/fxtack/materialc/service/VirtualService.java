package com.fxtack.materialc.service;

import com.fxtack.materialc.entity.VirtualFolder;
import com.fxtack.materialc.entity.format.FormatVirtualFolder;

import java.util.List;
import java.util.Map;

/**
 * 虚拟文件夹操作业务接口
 *
 * @author fxtack
 */
public interface VirtualService {

    List<VirtualFolder> getAll();

    VirtualFolder findById(int id);

    VirtualFolder findByAbsolutePath(String absolutePath);

    void save(VirtualFolder folder);

    void deleteFolder(int id);

    void updateFolder(VirtualFolder folder);

    void updateInnerFolder(int id, String innerProjectId);

    void updateRemark(int id, String newRemark);

    void updateName(int id, String newName);

    List<FormatVirtualFolder> findInnerFolder(int id);

    Map<Integer, String> findSerialPathInfoByPathId(int id);
}
