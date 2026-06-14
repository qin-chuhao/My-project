package study.demo.shop.module.service;

import org.springframework.stereotype.Service;
import study.demo.shop.module.entity.Product;
import study.demo.shop.module.mapper.ProductMapper;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@Service
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    public List<Product> getAllProductInfo() {

        return productMapper.getAll();
    }

    public Product getProductInfoById(BigInteger id) {
        return productMapper.getById(id);
    }

    public int createProduct(String coverImages, String title, Float productPrice, String productDetail) {
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        Product product = new Product()
                .setCoverImages(coverImages)
                .setTitle(title)
                .setProductPrice(productPrice)
                .setProductDetail(productDetail)
                .setCreateTime(timestamp)
                .setUpdateTime(timestamp)
                .setIsDeleted(0);
        return productMapper.insert(product);
    }

    public int updateProduct(BigInteger id, String coverImages, String title, Float productPrice, String productDetail) {
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        Product product = new Product()
                .setId(id)
                .setCoverImages(coverImages)
                .setTitle(title)
                .setProductPrice(productPrice)
                .setProductDetail(productDetail)
                .setUpdateTime(timestamp);
        return productMapper.update(product);
    }

    public int deleteProduct(BigInteger id) {
        return productMapper.delete(id, (int) (System.currentTimeMillis() / 1000));
    }

}

