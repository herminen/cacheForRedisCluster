package com.lh.stock.lhstock;

import com.lh.stock.lhstock.dao.UserDao;
import com.lh.stock.lhstock.syncdata.SyncDataThreadExecutor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages={"com.lh.stock.lhstock.dao"})
public class LhStockApplication {

    @Bean
    public SyncDataThreadExecutor syncDataThreadExecutor(){
        return SyncDataThreadExecutor.initSyncDataThreadExecutor();
    }

    public static void main(String[] args) {
        SpringApplication.run(LhStockApplication.class, args);
    }

}
