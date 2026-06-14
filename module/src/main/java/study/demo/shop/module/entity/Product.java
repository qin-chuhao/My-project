package study.demo.shop.module.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class Product {
    private BigInteger id;
    private String coverImages;
    private String title;
    private Float productPrice;
    private String productDetail;
    private Integer createTime;
    private Integer updateTime;
    private Integer isDeleted;


}

