package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class UserMaterialGroup {
    private Long groupId;

    private Long userId;

    private Long typeId;

    private Long productId;

    private String name;

    private String code;

    private int status;

    private Long parentId;

    private int computeMode;

    private String unit;

    private String shortCode;

    private int isSys;

    private Date created;

    private String creator;

    private Date modified;

    private String modifier;

}