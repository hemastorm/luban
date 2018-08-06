package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class OrderMaterial {
    private Long id;

    private Long userId;

    private Long tradeId;

    private Long orderId;

    private String typeCode;

    private String typeName;

    private String materialCode;

    private String materialName;

    private String color;

    private Integer size;

    private Integer count;

    private Date created;

    private String creator;

    private Date modified;

    private String modifior;

}