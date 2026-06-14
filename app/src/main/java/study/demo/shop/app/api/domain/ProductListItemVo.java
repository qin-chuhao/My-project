package study.demo.shop.app.api.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class ProductListItemVo {
    private String wallImage;
    private String title;
    private Float productPrice;
    private BigInteger productId;


}
