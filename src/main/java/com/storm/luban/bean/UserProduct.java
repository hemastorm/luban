package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserProduct {
    private Long id;

    private Long userId;

    private String name;

    private String code;

    private int statue;

}