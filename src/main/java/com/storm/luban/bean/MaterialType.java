package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MaterialType {
    private Long typeId;

    private Long productId;

    private String name;

    private String code;

    private int status;

    private Long parentId;

    private int computeMode;

    private String unit;

    private String shortCode;

    private int isLeaf;
    /**
     * 关联查询所有的属性
     */
    private List<MaterialAttrTemplate> attrs;
}