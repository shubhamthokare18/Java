package com.example.entity;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class AppConfig implements InitializingBean, DisposableBean {
    @Bean(initMethod = "engineInit", destroyMethod = "engineDestroy")
    public Engine engine() {
        return new Engine();
    }
    @Bean
    public Car car() {
        return new Car(engine());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Beans are created");
    }

    public void destroy()
    {
        System.out.println("Beans are destroyed");
    }

    @PostConstruct
    public void postConstruct()
    {
        System.out.println("Beans are created using post");
    }

    @PreDestroy
    public void preDestroy()
    {
        System.out.println("Beans are destroyed using pre");
    }
}
package com.example;

public class Car {
    private Engine engine;
    public Car(Engine engine) {
        this.engine=engine;
    }
    public void start() {
        System.out.println("Car started with " + engine.getType());
    }
}
package com.example;

public class Engine {
    public String getType() {
        return "V8 Engine";
    }

    public void engineInit()
    {
        System.out.println("Engine bean is created");
    }

    public void engineDestroy()
    {
        System.out.println("Engine bean is destroyed");
    }
}
package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Car car=context.getBean(Car.class);
        car.start();
        context.close();
    }
}
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>springjavaconfig</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.36</version>
    </dependency>
</dependencies>
</project>
