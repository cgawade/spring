package com.spring.jdbc.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.spring.jdbc.autowire.dao")
public class JdbcConfig {

    @Bean(name = "dataSource")
    public DataSource getDatasourceInstance(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("");

        return driverManagerDataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplateInstance(){
        return new JdbcTemplate(getDatasourceInstance());
    }

}
