package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private Long userId;

    private String name;

    private String address;

    private String contactName;

    private String contactMobile;

    private String contactPhone;

    private String note;

}