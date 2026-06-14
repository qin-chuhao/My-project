package study.demo.shop.app.api.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ProductInfoResultVo {

    private List<String> coverImages;
    private String title;
    private Float productPrice;
    private String productDetail;

}
