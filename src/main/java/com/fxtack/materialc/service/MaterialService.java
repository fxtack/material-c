package com.fxtack.materialc.service;

import com.fxtack.materialc.entity.Material;

import java.util.List;

/**
 * 素材操作业务接口
 *
 * @author fxtack
 */
public interface MaterialService {

    void save(Material material);

//    PageInfo<Material> getAttachment(int page, int limit);

    Material findById(int id);

    Material findByIdNoParseSize(int id);

    List<Material> findByPathId(Integer pathId);

    void deleteById(int id) throws Exception;

    void deleteById(Integer[] id);

    void updateRemark(int id, String newRemark);

    void updateName(int id, String newName);

    void updateVirtualPathId(int id, int pathId);

    void updateFavour(int id, boolean toFavour);

    void updateDelete(int id, boolean toDelete);

    void updateDelete(Integer[] id, boolean toDelete);

    void updateFavour(Integer[] id, boolean toFavour);

    void updateVirtualPathId(Integer[] id, Integer pathId);

    List<Material> findById(Integer[] id);

    void save(List<Material> materialList);

    List<Material> search(int pathId, String searchWord);

    List<Material> findAllFavour();

    List<Material> searchNameFromFavour(String searchWord);

    List<Material> findAllDelete();

    List<Material> searchNameFromDelete(String searchWord);

    List<Material> findByPathIdNoDelete(int pathId);

    List<Material> findAll();

    int countAll();

    int countFavour();

    int countDelete();
}
