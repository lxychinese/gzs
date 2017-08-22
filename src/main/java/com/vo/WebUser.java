package com.vo;

import java.util.List;

/**
 * 网站用户信息
 */
public class WebUser {
    private String username;
    private String password;
    private Integer ipSwitch;
    private List<String> platformList;
    private List<String> authorityList;
    private List<String> allowIpList;
    private List<String> groupList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(List<String> platformList) {
        this.platformList = platformList;
    }

    public List<String> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<String> authorityList) {
        this.authorityList = authorityList;
    }

    public List<String> getAllowIpList() {
        return allowIpList;
    }

    public void setAllowIpList(List<String> allowIpList) {
        this.allowIpList = allowIpList;
    }

    public Integer getIpSwitch() {
        return ipSwitch;
    }

    public void setIpSwitch(Integer ipSwitch) {
        this.ipSwitch = ipSwitch;
    }

    @Override
    public String toString() {
        return "WebUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ipSwitch=" + ipSwitch +
                ", platformList=" + platformList +
                ", authorityList=" + authorityList +
                ", allowIpList=" + allowIpList +
                '}';
    }

    public List<String> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<String> groupList) {
        this.groupList = groupList;
    }
}
