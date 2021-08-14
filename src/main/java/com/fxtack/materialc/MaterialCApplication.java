package com.fxtack.materialc;

import com.fxtack.materialc.thread.DeleteThread;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring boot 启动
 *
 * @author fxtack
 */
//@MapperScan("com.fxtack.materialc.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class MaterialCApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaterialCApplication.class, args);
    }

}
