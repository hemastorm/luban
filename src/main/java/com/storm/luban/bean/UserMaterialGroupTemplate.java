package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class UserMaterialGroupTemplate {
    private Long id;

    private Long userId;

    private Long groupId;

    private Long materialTypeId;

    private String attrName;

    private String attrCode;

    private int isComputer;

    private int isNeed;

    private String shortCode;

    private int state;

    private Date created;

    private String creator;

    private Date modified;

}