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
        basePackages = "com.example.task.repo.oracle",
        entityManagerFactoryRef = "oracleEntityManagerFactory",
        transactionManagerRef = "oracleTransactionManager"
)
@EntityScan("com.example.task.entity.oracle")
public class OracleConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.oracle.datasource")
    public DataSourceProperties oracleDataSource() {
        return new DataSourceProperties();
    }
    @Bean
    public DataSource getDataSource(@Qualifier("oracleDataSource")DataSourceProperties dataSourceProperties){
        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        driverManagerDataSource.setPassword(dataSourceProperties.getPassword());
        driverManagerDataSource.setUrl(dataSourceProperties.getUrl());
        driverManagerDataSource.setUsername(dataSourceProperties.getUsername());
        return driverManagerDataSource;
    }
    @Bean
    public JpaVendorAdapter getJpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter=new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setShowSql(true);
        return hibernateJpaVendorAdapter;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(@Qualifier("getJpaVendorAdapter")JpaVendorAdapter jpaVendorAdapter, @Qualifier("getDataSource")DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.example.task.entity.oracle");
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager oracleTransactionManager(@Qualifier("oracleEntityManagerFactory")LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        assert   localContainerEntityManagerFactoryBean.getObject()!=null;
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }
}
