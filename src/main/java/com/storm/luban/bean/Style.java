package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class Style {
    private Long id;

    private Long userId;

    private Long productId;

    private String productName;

    private Float price;

    private Float minArea;

    private String color;

    private Integer adjustSize;

    private Float extPrice;

    private String imgPath;

    private int priceType;

    private String formulaName;

    private String formulaCode;

    private String formulaVersion;

    private String note;

    private String creater;

    private Date created;

    private String modifier;

    private Date modified;

}