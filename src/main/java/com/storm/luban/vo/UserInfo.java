package com.storm.luban.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private Long userId;
    private String userNick;
    private Long accountId;
    private String accountName;
}
