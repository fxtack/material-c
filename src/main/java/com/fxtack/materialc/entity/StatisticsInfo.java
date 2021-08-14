package com.fxtack.materialc.entity;

/**
 * 统计数据 entity
 *
 * @author fxtack
 */
public class StatisticsInfo {

    private Integer id;
    private String fileType;
    private String fileName;
    private Integer fileNumber;
    private Long fileSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(Integer fileNumber) {
        this.fileNumber = fileNumber;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "StatisticsInfo{" +
                "id=" + id +
                ", fileType='" + fileType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileNumber=" + fileNumber +
                ", fileSize=" + fileSize +
                '}';
    }
}
