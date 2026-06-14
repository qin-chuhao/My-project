package study.demo.shop.module.mapper;

import org.apache.ibatis.annotations.*;
import study.demo.shop.module.entity.Product;
import java.util.List;
import java.math.BigInteger;

@Mapper
public interface ProductMapper {

    @Select("select * from product where is_deleted=0")
    List<Product> getAll();

    @Select("select * from product where id = #{id} and is_deleted=0")
    Product getById(BigInteger id);

    int insert(@Param("product") Product product);
    int update(@Param("product") Product product);

    @Update("update product set is_deleted=1,update_time=#{time} where id=#{id}")
    int delete(@Param("id") BigInteger id, @Param("time") Integer time);
}

