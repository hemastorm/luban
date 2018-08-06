package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {
    private Long accountId;

    private Long userId;

    private String name;

    private String code;

    private String pwd;

    private String mobile;

    private int isSub;

    private Long parentUserId;
}
