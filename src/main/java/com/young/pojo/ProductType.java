package com.young.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 商品分类表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductType implements Serializable {
    private Integer typeId;

    private Integer parentId;

    private String typeCode;

    private String typeName;

    private String typeDesc;

    private static final long serialVersionUID = 1L;
}