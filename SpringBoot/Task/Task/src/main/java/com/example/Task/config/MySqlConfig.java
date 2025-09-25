package com.example.Task.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.task.repo.mysql",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager"
)
@EntityScan("com.example.task.entity.mysql")
public class MySqlConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.mysql.datasource")
    public DataSourceProperties mysqlDataSource2() {
        return new DataSourceProperties();
    }
    @Bean
    public DataSource mysqlDataSource(@Qualifier("mysqlDataSource2")DataSourceProperties dataSourceProperties){
        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        driverManagerDataSource.setPassword(dataSourceProperties.getPassword());
        driverManagerDataSource.setUrl(dataSourceProperties.getUrl());
        driverManagerDataSource.setUsername(dataSourceProperties.getUsername());
        return driverManagerDataSource;
    }
    @Bean
    public JpaVendorAdapter mysqlJpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter=new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setShowSql(true);
        return hibernateJpaVendorAdapter;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(@Qualifier("mysqlJpaVendorAdapter")JpaVendorAdapter jpaVendorAdapter, @Qualifier("mysqlDataSource")DataSource dataSource) {
       LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
       localContainerEntityManagerFactoryBean.setDataSource(dataSource);
       localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
       localContainerEntityManagerFactoryBean.setPackagesToScan("com.example.task.entity.mysql");
       return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("mysqlEntityManagerFactory")LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
      assert   localContainerEntityManagerFactoryBean.getObject()!=null;
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }
}
