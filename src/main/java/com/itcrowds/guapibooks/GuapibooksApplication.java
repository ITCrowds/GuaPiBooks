package com.itcrowds.guapibooks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itcrowds.guapibooks.mapper")
public class GuapibooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuapibooksApplication.class, args);
    }
}
