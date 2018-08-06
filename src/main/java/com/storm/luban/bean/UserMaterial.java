package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class UserMaterial {
    private Long materialId;

    private Long userId;

    private Long productId;

    private Long groupId;

    private String name;

    private String code;

    private String color;

    private int state;

    private Date created;

    private String creator;

    private Date modified;

    private String modifier;

}