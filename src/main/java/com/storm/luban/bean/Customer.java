package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer {
    private Long customerId;

    private Long userId;

    private String userNick;

    private String name;

    private String phone;

    private String mobile;

    private int custormType;

    private String note;

}