package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class Trade {
    private Long tradeId;

    private Long userId;

    private String userNick;

    private Date sendTime;

    private Double payed;

    private String sellerMemo;

    private Double totalFee;

    private Double amount;

    private Double discountAmount;

    private Byte tradeType;

    private String custormName;

    private Byte shippingType;

    private Double shippingFee;

    private String receiverName;

    private String receiverMobile;

    private String receiverState;

    private String receiverCity;

    private String receiverDistinct;

    private String receiverAddress;

    private String note;

    private String creator;

    private Date created;

    private String modifyer;

    private Date modifyed;

}