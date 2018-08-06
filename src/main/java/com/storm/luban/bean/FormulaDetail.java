package com.storm.luban.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FormulaDetail {
    private Long id;

    private Long userId;

    private Long formulaId;

    private int computerMode;

    private Integer count;

    private Long typeId;

    private String typeName;

    private String typeCode;

    private String shortCode;

    private int status;

    private String formula;

    private String formulaStr;
}