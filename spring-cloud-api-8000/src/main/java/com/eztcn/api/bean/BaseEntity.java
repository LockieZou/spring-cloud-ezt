package com.eztcn.api.bean;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    protected Integer deleteFlag;
    protected Long createdBy;
    protected Date createdWhen;
    protected Long updatedBy;
    protected Date updatedWhen;

}
