package study.demo.shop.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.demo.shop.module.entity.Product;
import study.demo.shop.module.service.ProductService;
import study.demo.shop.app.api.domain.ProductInfoResultVo;
import study.demo.shop.app.api.domain.ProductListItemVo;
import study.demo.shop.app.api.domain.ProductListResultVo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class AppApi {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/list")
    public ProductListResultVo productAll() {
        List<Product> products = productService.getAllProductInfo();
        List<ProductListItemVo> list = new ArrayList<>();
        for (Product product : products) {
            String coverImages = product.getCoverImages();
            String wallImage = null;

            if (coverImages != null && !coverImages.isEmpty()) {
                int index = coverImages.indexOf("$");
                if (index != -1) {
                    wallImage = coverImages.substring(0, index);
                } else {
                    wallImage = coverImages;
                }
            }
            ProductListItemVo itemVo = new ProductListItemVo()
                    .setWallImage(wallImage)
                    .setTitle(product.getTitle())
                    .setProductPrice(product.getProductPrice())
                    .setProductId(product.getId());

            list.add(itemVo);
        }
        ProductListResultVo resultVo = new ProductListResultVo();
        resultVo.setList(list);
        return resultVo;

    }

    @RequestMapping("/product/info")
    public ProductInfoResultVo productInfo(@RequestParam(name = "productId") BigInteger productId) {
        Product product = productService.getProductInfoById(productId);
        return new ProductInfoResultVo()
                .setCoverImages(Arrays.asList(product.getCoverImages().split("\\$")))
                .setTitle(product.getTitle())
                .setProductPrice(product.getProductPrice())
                .setProductDetail(product.getProductDetail());


    }


}

