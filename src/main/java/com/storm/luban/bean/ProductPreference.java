package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductPreference {
    private Long id;

    private Long productId;

    private String name;

    private String valuess;

    private int status;

    private String note;

}