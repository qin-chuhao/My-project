package study.demo.shop.app.api.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ProductListResultVo {
    private List<ProductListItemVo> list;


}
