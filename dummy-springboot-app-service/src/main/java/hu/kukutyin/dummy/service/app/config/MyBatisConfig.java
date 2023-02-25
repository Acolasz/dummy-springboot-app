package hu.kukutyin.dummy.service.app.config;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Configuration;

@MapperScan(
        basePackages = "hu.kukutyin.dummy.service.app.dao",
        markerInterface = hu.kukutyin.dummy.service.app.dao.mapper.MyBatisMapper.class
)
@Configuration
public class MyBatisConfig {
}
