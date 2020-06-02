package com.lh.stock.lhstock;

import com.lh.stock.lhstock.dao.UserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LhStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(LhStockApplication.class, args);
    }

}
