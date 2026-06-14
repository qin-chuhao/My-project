package study.demo.shop.console.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.demo.shop.module.service.ProductService;

import java.math.BigInteger;


@RestController
public class ConsoleApi {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/create")
    public String createProduct(@RequestParam(name = "coverImages") String coverImages,
                                @RequestParam(name = "title") String title,
                                @RequestParam(name = "productPrice") Float productPrice,
                                @RequestParam(name = "productDetail") String productDetail) {

        int result = productService.createProduct(coverImages, title, productPrice, productDetail);
        return result == 1 ? "成功" : "失败";
    }

    @RequestMapping("/product/update")
    public String updateProduct(@RequestParam(name = "productId") BigInteger productId,
                                @RequestParam(name = "coverImages") String coverImages,
                                @RequestParam(name = "title") String title,
                                @RequestParam(name = "productPrice") Float productPrice,
                                @RequestParam(name = "productDetail") String productDetail) {

        int result = productService.updateProduct(productId, coverImages, title, productPrice, productDetail);
        return result == 1 ? "成功" : "失败";
    }

    @RequestMapping("/product/delete")
    public String deleteProduct(@RequestParam(name = "productId") BigInteger productId) {
        int result = productService.deleteProduct(productId);
        return result == 1 ? "成功" : "失败";
    }




}

