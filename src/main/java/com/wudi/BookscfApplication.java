package com.wudi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wudi.mapper")
public class BookscfApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookscfApplication.class, args);
    }

}
