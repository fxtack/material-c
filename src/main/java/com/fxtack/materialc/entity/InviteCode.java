package com.fxtack.materialc.entity;

public class InviteCode {
    private Integer Id;
    private String inviteValue;
    private String inviteCreateDate;
    private String inviteEndDate;
    private Integer inviteStat = 0;
    private Integer inviteUsedTimes = 0;
    private String inviteRemark;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getInviteValue() {
        return inviteValue;
    }

    public void setInviteValue(String inviteValue) {
        this.inviteValue = inviteValue;
    }

    public String getInviteCreateDate() {
        return inviteCreateDate;
    }

    public void setInviteCreateDate(String inviteCreateDate) {
        this.inviteCreateDate = inviteCreateDate;
    }

    public String getInviteEndDate() {
        return inviteEndDate;
    }

    public void setInviteEndDate(String inviteEndDate) {
        this.inviteEndDate = inviteEndDate;
    }

    public Integer getInviteStat() {
        return inviteStat;
    }

    public void setInviteStat(Integer inviteStat) {
        this.inviteStat = inviteStat;
    }

    public Integer getInviteUsedTimes() {
        return inviteUsedTimes;
    }

    public void setInviteUsedTimes(Integer inviteUsedTimes) {
        this.inviteUsedTimes = inviteUsedTimes;
    }

    public String getInviteRemark() {
        return inviteRemark;
    }

    public void setInviteRemark(String inviteRemark) {
        this.inviteRemark = inviteRemark;
    }

    @Override
    public String toString() {
        return "InviteCode{" +
                "Id=" + Id +
                ", inviteValue='" + inviteValue + '\'' +
                ", inviteCreateDate='" + inviteCreateDate + '\'' +
                ", inviteEndDate='" + inviteEndDate + '\'' +
                ", inviteStat=" + inviteStat +
                ", inviteUsedTimes='" + inviteUsedTimes + '\'' +
                ", inviteRemark='" + inviteRemark + '\'' +
                '}';
    }
}
