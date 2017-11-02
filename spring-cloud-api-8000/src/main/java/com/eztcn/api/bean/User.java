package com.eztcn.api.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zouxiliang
 * @Description:
 * @Date: Created in 9:33 2017/10/24
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String euNumber;
    private String account;
    private String euPassword;
    private String chineseName;
    private Integer sex;
    private String euMobile;
    private String euEmail;
    private String euNickname;
    private String idNumber;
    private Integer status;
    private Integer userType;
    private Integer loginType;
    private Integer roleId;
    private Integer registerType;
    private Integer hospitalId;
    private Date birthday;
    private String imageUrl;
    private String province;
    private String city;
    private String area;
    private String registerPlatId;
    private String qqNumber;
    private String euQq;
    private String weixinNumber;
    private String enWeixin;
    private String euAlipay;
    private String address;
    private Integer euLoginDays;
    private Date euLastLoginTime;
    private Integer euMessageSet;
    private Integer retryPwdNums;
    private Date retryPwdTime;
    private String description;
    private Integer isAdmin;
    private Integer createdBy;
    private Date createdWhen;
    private Integer updatedBy;
    private Date updatedWhen;
}
