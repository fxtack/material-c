package com.fxtack.materialc.service.impl;

import com.fxtack.materialc.entity.VirtualFolder;
import com.fxtack.materialc.entity.format.FormatVirtualFolder;
import com.fxtack.materialc.mapper.VirtualFolderMapper;
import com.fxtack.materialc.service.VirtualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 虚拟文件夹操作业务实现
 *
 * @author fxtack
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class VirtualServiceImpl implements VirtualService {

    private static final String VIRTUAL_FOLDER_CACHE = "virtualFolders";

    @Autowired
    VirtualFolderMapper virtualFolderMapper;

    @Override
    public List<VirtualFolder> getAll() {
        return virtualFolderMapper.selectAll();
    }

    @Override
    @Cacheable(value = VIRTUAL_FOLDER_CACHE, key = "'findById'+#id")
    public VirtualFolder findById(int id) {
        return virtualFolderMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(value = VIRTUAL_FOLDER_CACHE, key = "'findByAbsolutePath'+#absolutePath")
    public VirtualFolder findByAbsolutePath(String absolutePath) {
        return virtualFolderMapper.selectByAbsolutePath(absolutePath);
    }

    @Override
    @CacheEvict(value = VIRTUAL_FOLDER_CACHE, allEntries = true, beforeInvocation = true)
    public void save(VirtualFolder folder) {
        virtualFolderMapper.insert(folder);
    }

    @Override
    @CacheEvict(value = VIRTUAL_FOLDER_CACHE, allEntries = true, beforeInvocation = true)
    public void deleteFolder(int id) {
        virtualFolderMapper.deleteByPrimaryKey(id);
    }

    @Override
    @CacheEvict(value = VIRTUAL_FOLDER_CACHE, allEntries = true, beforeInvocation = true)
    public void updateFolder(VirtualFolder folder) {
        virtualFolderMapper.updateByPrimaryKey(folder);
    }

    @Override
    public void updateInnerFolder(int id, String innerProjectId) {
        VirtualFolder virtualFolder = new VirtualFolder(
                id,null,null,null,
                null,null,null,
                innerProjectId);
        virtualFolderMapper.updateByPrimaryKeySelective(virtualFolder);
    }

    @Override
    @CacheEvict(value = VIRTUAL_FOLDER_CACHE, allEntries = true, beforeInvocation = true)
    public void updateRemark(int id, String newRemark) {
        VirtualFolder virtualFolder = new VirtualFolder();
        virtualFolder.setId(id);
        virtualFolder.setFolderRemark(newRemark);
        virtualFolderMapper.updateByPrimaryKeySelective(virtualFolder);
    }

    @Override
    @CacheEvict(value = VIRTUAL_FOLDER_CACHE, allEntries = true, beforeInvocation = true)
    public void updateName(int id, String newName) {
        VirtualFolder virtualFolder = new VirtualFolder();
        virtualFolder.setId(id);
        virtualFolder.setFolderName(newName);
        virtualFolderMapper.updateByPrimaryKeySelective(virtualFolder);
    }

    @Override
    public List<FormatVirtualFolder> findInnerFolder(int id) {
        VirtualFolder folder = virtualFolderMapper.selectByPrimaryKey(id);
        if(folder.getInnerFolderId() == null || folder.getInnerFolderId().equals("")) {
            return null;
        }
        return Arrays.asList(folder.getInnerFolderId().split(";"))
                .stream()
                .map(e->FormatVirtualFolder.buildFormatVirtualFolder(virtualFolderMapper.selectByPrimaryKey(Integer.valueOf(e))))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, String> findSerialPathInfoByPathId(int id) {
        VirtualFolder virtualFolder = virtualFolderMapper.selectByPrimaryKey(id);
        Map<Integer, String> map = new HashMap<>();
        if(virtualFolder.getAbsoluteFolderPathId() == null || virtualFolder.getAbsoluteFolderPathId().equals("")) {
            return null;
        }
        List<Integer> idList = Arrays.asList(virtualFolder.getAbsoluteFolderPathId().split(";"))
                .stream()
                .map(e->Integer.valueOf(e))
                .collect(Collectors.toList());
        idList.stream().forEach(e->map.put(e, virtualFolderMapper.selectByPrimaryKey(e).getFolderName()));
        return map;
    }
}
