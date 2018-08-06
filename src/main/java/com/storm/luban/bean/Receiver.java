package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Receiver {
    private Long receiverId;

    private Long userId;

    private String userNick;

    private String name;

    private String phone;

    private String mobile;

    private String state;

    private String city;

    private String distinct;

    private String address;

    private String zip;

    private String note;

    private int shippingType;

}