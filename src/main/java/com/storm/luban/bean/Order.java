package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {
    private Long orderId;

    private Long tradeId;

    private Long userId;

    private String userNick;

    private Long productId;

    private String productName;

    private Long styleId;

    private String styleName;

    private Long formulaId;

    private String formulaName;

    private String mainProfile;

    private String color;

    private Integer height;

    private Integer width;

    private Integer num;

    private Float area;

    private Double price;

    private Double orderPayment;

    private String picPath;

    private Float minComputeArea;

}