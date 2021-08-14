package com.fxtack.materialc.mapper;

import com.fxtack.materialc.entity.Material;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO 接口
 * 数据库表: material
 * entity: Material
 *
 * @author fxtack
 */
@Repository
@Mapper
public interface MaterialMapper {

    Material selectByPrimaryKey(Integer id);

    List<Material> selectByPathId(Integer path);

    int deleteByPrimaryKey(Integer id);

    int insert(Material material);

    int insertSelective(Material material);

    int updateByPrimaryKeySelective(Material material);

    int multipleUpdateDeleteByPrimaryKey(Integer[] idList, Integer toDelete);

    int multipleUpdateFavourByPrimaryKey(Integer[] idList, Integer toFavour);

    int multipleUpdateVirtualPathByPrimaryKey(Integer[] idList, Integer moveToPathId);

    List<Material> multipleSelectByPrimaryKey(Integer[] idList);

    int multipleInsert(List<Material> list);

    int multipleDelete(Integer[] idList);

    List<Material> searchName(@Param("pathId") Integer pathId, @Param("searchWord") String searchWord);

    List<Material> selectByFavour();

    List<Material> selectByDelete();

    List<Material> selectByPathIdNoDelete(Integer pathId);

    List<Material> selectAll();

    int countAll();

    int countFavour();

    int countDelete();
}
