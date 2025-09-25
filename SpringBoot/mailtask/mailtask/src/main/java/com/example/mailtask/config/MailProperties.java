package com.example.mailtask.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailProperties {
    private Imap imap;

    @Getter
    @Setter
    public static class Imap {
        private String host;
        private int port;
        private String protocol;
    }

    @Configuration
    @EnableAsync
    public static class AsyncConfig {

        @Bean(name = "taskExecutor")
        public Executor taskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(3);
            executor.setMaxPoolSize(5);
            executor.setQueueCapacity(50);
            executor.setThreadNamePrefix("MailThread-");
            executor.initialize();
            return executor;
        }
    }
}