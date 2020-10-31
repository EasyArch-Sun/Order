package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.config.info.JdbcInfo;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan("com.example.dao.mapper")
public class DataConfig {

    @Resource
    private JdbcInfo jdbcInfo;

    @Bean
    public DataSource getDataSource() throws SQLException{

        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl(jdbcInfo.getUrl());
        dataSource.setUsername(jdbcInfo.getUsername());
        dataSource.setPassword(jdbcInfo.getPassword());
        dataSource.setDriverClassName(jdbcInfo.getDriver());

        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplete(DataSource dataSource){

        return new JdbcTemplate(dataSource);
        //return getJdbcTemplete(dataSource);
    }

    /**
     * 装配事务管理器
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * JDBC事务操作配置
     */
    @Bean(name = "txTemplate")
    public TransactionTemplate transactionTemplate(DataSourceTransactionManager dataSourceTransactionManager) {
        return new TransactionTemplate(dataSourceTransactionManager);
    }


    /**
     * mybatis
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        return sqlSessionFactoryBean;
    }
}
