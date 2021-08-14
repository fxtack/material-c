package com.fxtack.materialc.entity;

/**
 * 个人信息 entity
 *
 * @author fxtack
 */
public class LoginUser {

    private Integer id;
    private String userName;
    private Integer userSex;
    private String userPassword;
    private String authorities;
    private String roles;
    private String job;
    private String area;
    private String userAddress;
    private String userContact;
    private String userEmail;
    private String userAutograph;
    private String userCreateDate;
    private String userInvite;

    public LoginUser() {
    }

    public LoginUser(Integer id, String userName, Integer userSex, String userPassword, String authorities, String roles, String job, String area, String userAddress, String userContact, String userEmail, String userAutograph) {
        this.id = id;
        this.userName = userName;
        this.userSex = userSex;
        this.userPassword = userPassword;
        this.authorities = authorities;
        this.roles = roles;
        this.job = job;
        this.area = area;
        this.userAddress = userAddress;
        this.userContact = userContact;
        this.userEmail = userEmail;
        this.userAutograph = userAutograph;
    }

    public LoginUser(Integer id, String userName, Integer userSex, String userPassword, String authorities, String roles, String job, String area, String userAddress, String userContact, String userEmail, String userAutograph, String userCreateDate, String userInvite) {
        this.id = id;
        this.userName = userName;
        this.userSex = userSex;
        this.userPassword = userPassword;
        this.authorities = authorities;
        this.roles = roles;
        this.job = job;
        this.area = area;
        this.userAddress = userAddress;
        this.userContact = userContact;
        this.userEmail = userEmail;
        this.userAutograph = userAutograph;
        this.userCreateDate = userCreateDate;
        this.userInvite = userInvite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAutograph() {
        return userAutograph;
    }

    public void setUserAutograph(String userAutograph) {
        this.userAutograph = userAutograph;
    }

    public String getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(String userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public String getUserInvite() {
        return userInvite;
    }

    public void setUserInvite(String userInvite) {
        this.userInvite = userInvite;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userPassword='" + userPassword + '\'' +
                ", authorities='" + authorities + '\'' +
                ", roles='" + roles + '\'' +
                ", job='" + job + '\'' +
                ", area='" + area + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userContact='" + userContact + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAutograph='" + userAutograph + '\'' +
                ", userCreateDate='" + userCreateDate + '\'' +
                ", userInvite='" + userInvite + '\'' +
                '}';
    }
}
