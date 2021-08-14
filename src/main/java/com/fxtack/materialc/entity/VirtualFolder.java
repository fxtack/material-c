package com.fxtack.materialc.entity;

import java.util.Date;

/**
 * 虚拟文件夹 entity
 *
 * @author fxtack
 */
public class VirtualFolder {

    private Integer id;
    private String folderName;
    private Date folderCreateDate;
    private Integer folderFileCount;
    private String folderFileSize;
    private String folderAbsolute;
    private String folderRemark;
    private String innerFolderId;
    private String absoluteFolderPathId;

    public VirtualFolder() {
    }

    public VirtualFolder(Integer id, String folderName, Date folderCreateDate, Integer folderFileCount, String folderFileSize, String folderAbsolute, String folderRemark, String innerFolderId) {
        this.id = id;
        this.folderName = folderName;
        this.folderCreateDate = folderCreateDate;
        this.folderFileCount = folderFileCount;
        this.folderFileSize = folderFileSize;
        this.folderAbsolute = folderAbsolute;
        this.folderRemark = folderRemark;
        this.innerFolderId = innerFolderId;
    }

    public VirtualFolder(Integer id, String folderName, Date folderCreateDate, Integer folderFileCount, String folderFileSize, String folderAbsolute, String folderRemark, String innerFolderId, String absoluteFolderPathId) {
        this.id = id;
        this.folderName = folderName;
        this.folderCreateDate = folderCreateDate;
        this.folderFileCount = folderFileCount;
        this.folderFileSize = folderFileSize;
        this.folderAbsolute = folderAbsolute;
        this.folderRemark = folderRemark;
        this.innerFolderId = innerFolderId;
        this.absoluteFolderPathId = absoluteFolderPathId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Date getFolderCreateDate() {
        return folderCreateDate;
    }

    public void setFolderCreateDate(Date folderCreateDate) {
        this.folderCreateDate = folderCreateDate;
    }

    public Integer getFolderFileCount() {
        return folderFileCount;
    }

    public void setFolderFileCount(Integer folderFileCount) {
        this.folderFileCount = folderFileCount;
    }

    public String getFolderFileSize() {
        return folderFileSize;
    }

    public void setFolderFileSize(String folderFileSize) {
        this.folderFileSize = folderFileSize;
    }

    public String getFolderAbsolute() {
        return folderAbsolute;
    }

    public void setFolderAbsolute(String folderAbsolute) {
        this.folderAbsolute = folderAbsolute;
    }

    public String getFolderRemark() {
        return folderRemark;
    }

    public void setFolderRemark(String folderRemark) {
        this.folderRemark = folderRemark;
    }

    public String getInnerFolderId() {
        return innerFolderId;
    }

    public void setInnerFolderId(String innerFolderId) {
        this.innerFolderId = innerFolderId;
    }

    public String getAbsoluteFolderPathId() {
        return absoluteFolderPathId;
    }

    public void setAbsoluteFolderPathId(String absoluteFolderPathId) {
        this.absoluteFolderPathId = absoluteFolderPathId;
    }

    @Override
    public String toString() {
        return "VirtualFolder{" +
                "id=" + id +
                ", folderName='" + folderName + '\'' +
                ", folderCreateDate=" + folderCreateDate +
                ", folderFileCount=" + folderFileCount +
                ", folderFileSize='" + folderFileSize + '\'' +
                ", folderAbsolute='" + folderAbsolute + '\'' +
                ", folderRemark='" + folderRemark + '\'' +
                ", innerFolderId='" + innerFolderId + '\'' +
                ", absoluteFolderPathId='" + absoluteFolderPathId + '\'' +
                '}';
    }
}
