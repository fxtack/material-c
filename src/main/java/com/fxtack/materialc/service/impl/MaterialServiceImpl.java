package com.fxtack.materialc.service.impl;

import com.fxtack.materialc.entity.Material;
import com.fxtack.materialc.mapper.MaterialMapper;
import com.fxtack.materialc.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 素材操作业务实现
 *
 * @author fxtack
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class MaterialServiceImpl implements MaterialService {

    private static final String ATTACHMENTS_CACHE_NAME = "attachments";

    @Autowired
    private MaterialMapper materialMapper;

    @Override//562
    @CacheEvict(value = ATTACHMENTS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void save(Material material){
        materialMapper.insert(material);
    }

    @Override
    @Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'findById'+#id")
    public Material findById(int id) {
        return findByIdNoParseSize(id) != null ? materialMapper.selectByPrimaryKey(id).parseSize() : null;
    }

    @Override
    @Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'findById'+#id")
    public Material findByIdNoParseSize(int id) {
        return materialMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'findByPathId'+#pathId")
    public List<Material> findByPathId(Integer pathId) {
        return materialMapper.selectByPathId(pathId).stream().map(e->e.parseSize()).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'search'+#searchWord")
    public List<Material> search(int pathId, String searchWord) {
        return materialMapper.searchName(pathId,searchWord).stream().map(e->e.parseSize()).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'findAllFavour'")
    public List<Material> findAllFavour() {
        return materialMapper.selectByFavour().stream().map(e->e.parseSize()).filter(e->e.getIsDelete()!=1).collect(Collectors.toList());
    }


    @Override
    @Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'searchNameFromDelete'+#searchWord")
    public List<Material> searchNameFromDelete(String searchWord) {
        List<Material> list = materialMapper.searchName(null, searchWord);
        return list.stream().filter(e->{return e.getIsDelete() == 1;}).map(e->e.parseSize()).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'searchNameFromFavour'+#searchWord")
    public List<Material> searchNameFromFavour(String searchWord) {
        List<Material> list = materialMapper.searchName(null, searchWord);
        return list.stream().filter(e->{ return e.getIsFavour() == 1;}).map(e->e.parseSize()).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'findAllDelete'")
    public List<Material> findAllDelete() {
        return materialMapper.selectByDelete().stream().map(e->e.parseSize()).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'findByPathIdNoDelete'+#pathId")
    public List<Material> findByPathIdNoDelete(int pathId) {
        return materialMapper.selectByPathIdNoDelete(pathId).stream().map(e->e.parseSize()).collect(Collectors.toList());
    }

    @Override
    @CacheEvict(value = ATTACHMENTS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void deleteById(int id) throws Exception {
        materialMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteById(Integer[] id) {
        materialMapper.multipleDelete(id);
    }

    @Override
    @CacheEvict(value = ATTACHMENTS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void updateRemark(int id, String newRemark) {
        Material material = new Material();
        material.setId(id);
        material.setRemark(newRemark);
        materialMapper.updateByPrimaryKeySelective(material);
    }

    @Override
    @CacheEvict(value = ATTACHMENTS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void updateName(int id, String newName) {
        Material material = new Material();
        material.setId(id);
        material.setPictureName(newName);
        materialMapper.updateByPrimaryKeySelective(material);
    }

    @Override
    public void updateVirtualPathId(int id, int pathId) {
        Material material = new Material();
        material.setId(id);
        material.setVirtualPathId(pathId);
        materialMapper.updateByPrimaryKeySelective(material);
    }

    @Override
    @CacheEvict(value = ATTACHMENTS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void updateFavour(int id, boolean toFavour) {
        Material material = new Material();
        material.setId(id);
        if(toFavour) {
            material.setIsFavour(1);
        }else {
            material.setIsFavour(0);
        }
        materialMapper.updateByPrimaryKeySelective(material);
    }

    @Override
    @CacheEvict(value = ATTACHMENTS_CACHE_NAME, allEntries = true, beforeInvocation = true)
    public void updateDelete(int id, boolean toDelete) {
        Material material = new Material();
        material.setId(id);
        if(toDelete) {
            material.setIsDelete(1);
        }else {
            material.setIsDelete(0);
        }
        materialMapper.updateByPrimaryKeySelective(material);
    }

    @Override
    public void updateDelete(Integer[] id, boolean toDelete) {
        materialMapper.multipleUpdateDeleteByPrimaryKey(id, toDelete ? 1 : 0);
    }

    @Override
    public void updateFavour(Integer[] id, boolean toFavour) {
        materialMapper.multipleUpdateFavourByPrimaryKey(id, toFavour ? 1 : 0);
    }

    @Override
    public void updateVirtualPathId(Integer[] id, Integer pathId) {
        materialMapper.multipleUpdateVirtualPathByPrimaryKey(id, pathId);
    }

    @Override
    public List<Material> findById(Integer[] id) {
        return materialMapper.multipleSelectByPrimaryKey(id);
    }

    @Override
    public void save(List<Material> materialList) {
        materialMapper.multipleInsert(materialList);
    }

    @Override
    @Cacheable(value = ATTACHMENTS_CACHE_NAME, key = "'findAll'")
    public List<Material> findAll() {
        return materialMapper.selectAll().stream().map(e->e.parseSize()).collect(Collectors.toList());
    }

    @Override
    public int countAll() {
        return materialMapper.countAll();
    }

    @Override
    public int countFavour() {
        return materialMapper.countFavour();
    }

    @Override
    public int countDelete() {
        return materialMapper.countDelete();
    }
}
