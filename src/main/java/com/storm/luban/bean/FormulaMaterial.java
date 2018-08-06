package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FormulaMaterial {
    private Long id;

    private Long userId;

    private Long formulaId;

    private Long typeId;

    private String unit;

    private int computerMode;

    private int status;

    private String shortCode;

}