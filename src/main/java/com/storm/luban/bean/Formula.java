package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class Formula {
    private Long id;

    private Long userId;

    private Long productId;

    private String name;

    private String code;

    private String version;

    private int status;

    private String creater;

    private Date created;

    private String modifier;

    private Date modified;

    private String note;

}