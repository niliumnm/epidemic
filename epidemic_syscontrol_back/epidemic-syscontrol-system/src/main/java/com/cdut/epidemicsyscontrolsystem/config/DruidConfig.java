package com.cdut.epidemicsyscontrolsystem.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.cdut.epidemicsyscontrolsystem.properties.DruidProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
import java.util.HashMap;

@Configuration
@EnableConfigurationProperties(DruidProperty.class)
public class DruidConfig {

    @Autowired
    private DruidProperty druidProperty;

    @Bean
    @ConditionalOnMissingBean(DruidDataSource.class)
    public DruidDataSource druidDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(druidProperty.getUsername());
        dataSource.setPassword(druidProperty.getPassword());
        dataSource.setUrl(druidProperty.getUrl());
        dataSource.setInitialSize(druidProperty.getInitialSize());
        dataSource.setMinIdle(druidProperty.getMinIdle());
        dataSource.setMaxActive(druidProperty.getMaxActive());
        dataSource.setMaxWait(druidProperty.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(druidProperty.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidProperty.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(druidProperty.getValidationQuery());
        dataSource.setTestWhileIdle(druidProperty.isTestWhileIdle());
        dataSource.setTestOnBorrow(druidProperty.isTestOnBorrow());
        dataSource.setTestOnReturn(druidProperty.isTestOnReturn());
        dataSource.setPoolPreparedStatements(druidProperty.isPoolPreparedStatements());
        dataSource.setFilters(druidProperty.getFilters());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidProperty.getMaxPoolPreparedStatementPerConnectionSize());
        dataSource.setUseGlobalDataSourceStat(druidProperty.isUseGlobalDataSourceStat());
        dataSource.setConnectionProperties(druidProperty.getConnectionProperties());
        return dataSource;
    }

    /**
     * 配置数据状态监控Servlet
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet(){
        // 设置Servlet和其url
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        // 设置的字段固定
        HashMap<String, String> initParameters = new HashMap<>();
        //设置允许访问的ip
        initParameters.put("allow","localhost");
        // 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高  bean.addInitParameter("deny", "127.0.0.1");

        // 添加控制台管理用户
        bean.addInitParameter("loginUsername", "root");
        bean.addInitParameter("loginPassword", "123456");
        // 是否能够重置数据
        bean.addInitParameter("resetEnable", "false");
        bean.setInitParameters(initParameters);
        return bean;
    }

}
