package com.dsr.springboot_data;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SpringbootDataApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println("datasource:" + dataSource.getClass());
        System.out.println(dataSource.getConnection());
        dataSource = (DruidDataSource) dataSource;
        System.out.println(((DruidDataSource) dataSource).getInitialSize());
        System.out.println(((DruidDataSource) dataSource).getMinIdle());
        System.out.println(((DruidDataSource) dataSource).getMaxActive());
    }

}
