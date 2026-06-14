package study.demo.shop.console.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "study.demo.shop")
@MapperScan("study.demo.shop.module.mapper")
public class ConsoleApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConsoleApiApplication.class, args);
    }

}

