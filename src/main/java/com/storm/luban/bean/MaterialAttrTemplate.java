package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MaterialAttrTemplate {
    private Long id;

    private Long materialTypeId;

    private String attrName;

    private String attrCode;

    private int isComputer;

    private int isNeed;

    private String shortCode;

    private int state;

    private int sort;

}