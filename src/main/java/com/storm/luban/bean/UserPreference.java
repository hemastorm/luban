package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPreference {
    private Long id;

    private Long accountId;

    private Long userId;

    private String property;

    private String values;

    private int status;

    private String note;

}