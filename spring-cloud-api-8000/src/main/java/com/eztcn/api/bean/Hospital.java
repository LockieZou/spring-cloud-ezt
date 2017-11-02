package com.eztcn.api.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zouxiliang
 * @Description:
 * @Date: Created in 10:32 2017/10/23
 */
@Data
public class Hospital implements Serializable {
    private Integer id;
    private String name;
    private String shortName;
    private Integer type;
    private Integer level;
    private Integer hospitalType;
    private Integer hospitalModel;
    private String fax;
    private String logo;
    private String zipcode;
    private String website;
    private String province;
    private String city;
    private String county;
    private String address;
    private Double latitude;
    private Double longitude;
    private Integer status;
    private String introduction;
    private String picture;
    private Integer deleteFlag;
    private Integer createdBy;
    private Date createdWhen;
    private Integer updatedBy;
    private Date updatedWhen;
}
