//启动类  
package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // 标记为启动类
@MapperScan("org.example.mapper") //启动类找到映射接口，自动扫描
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}