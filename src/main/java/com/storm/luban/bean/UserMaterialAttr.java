package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class UserMaterialAttr {
    private Long id;

    private Long materialId;

    private Long userId;

    private String attrName;

    private String attrCode;

    private int statue;

    private String creator;

    private Date created;

    private String modifier;

    private Date modifior;

}