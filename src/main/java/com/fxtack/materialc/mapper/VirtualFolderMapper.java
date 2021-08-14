package com.fxtack.materialc.mapper;

import com.fxtack.materialc.entity.VirtualFolder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO 接口
 * 数据库表: virtual_folder
 * entity: VirtualFolder
 *
 * @author fxtack
 */
@Repository
@Mapper
public interface VirtualFolderMapper {

    List<VirtualFolder> selectAll();

    VirtualFolder selectByAbsolutePath(String absolutePath);

    VirtualFolder selectByPrimaryKey(Integer id);

    int insert(VirtualFolder virtualFolder);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(VirtualFolder virtualFolder);

    int updateByPrimaryKeySelective(VirtualFolder virtualFolder);

}
