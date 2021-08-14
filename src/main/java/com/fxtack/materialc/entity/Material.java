package com.fxtack.materialc.entity;


import com.fxtack.materialc.util.Util;

import java.util.Date;


/**
 * 素材 entity
 *
 * @author fxtack
 */
public class Material {
    protected Integer id;
    protected String pictureName;
    protected String picturePath;
    protected String pictureSmallPath;
    protected String pictureType;
    protected Date pictureCreateDate;
    protected String pictureSize;
    protected String pictureSuffix;
    protected String pictureWh;
    protected Integer virtualPathId;
    protected String remark;
    protected Integer isFavour;
    protected Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName == null ? null : pictureName.trim();
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }

    public String getPictureSmallPath() {
        return pictureSmallPath;
    }

    public void setPictureSmallPath(String pictureSmallPath) {
        this.pictureSmallPath = pictureSmallPath == null ? null : pictureSmallPath.trim();
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType == null ? null : pictureType.trim();
    }

    public Date getPictureCreateDate() {
        return pictureCreateDate;
    }

    public void setPictureCreateDate(Date pictureCreateDate) {
        this.pictureCreateDate = pictureCreateDate;
    }

    public String getPictureSize() {
        return pictureSize;
    }

    public void setPictureSize(String pictureSize) {
        this.pictureSize = pictureSize == null ? null : pictureSize.trim();
    }

    public String getPictureSuffix() {
        return pictureSuffix;
    }

    public void setPictureSuffix(String pictureSuffix) {
        this.pictureSuffix = pictureSuffix == null ? null : pictureSuffix.trim();
    }

    public String getPictureWh() {
        return pictureWh;
    }

    public void setPictureWh(String pictureWh) {
        this.pictureWh = pictureWh == null ? null : pictureWh.trim();
    }

    public Integer getVirtualPathId() {
        return virtualPathId;
    }

    public void setVirtualPathId(Integer virtualPathId) {
        this.virtualPathId = virtualPathId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsFavour() {
        return isFavour;
    }

    public void setIsFavour(Integer isFavour) {
        this.isFavour = isFavour;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Material parseSize() {
        this.pictureSize = Util.parseSize(Integer.valueOf(this.pictureSize));
        return this;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", pictureName='" + pictureName + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", pictureSmallPath='" + pictureSmallPath + '\'' +
                ", pictureType='" + pictureType + '\'' +
                ", pictureCreateDate=" + pictureCreateDate +
                ", pictureSize='" + pictureSize + '\'' +
                ", pictureSuffix='" + pictureSuffix + '\'' +
                ", pictureWh='" + pictureWh + '\'' +
                ", virtualPathId=" + virtualPathId +
                ", remark='" + remark + '\'' +
                ", isFavour=" + isFavour +
                ", isDelete=" + isDelete +
                '}';
    }
}
