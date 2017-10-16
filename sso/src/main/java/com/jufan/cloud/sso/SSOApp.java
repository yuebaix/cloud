package com.jufan.cloud.sso;

import com.jufan.cloud.sso.common.util.SecurityUtils;
import com.jufan.cloud.sso.repository.support.WiselyRepositoryImpl;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringCloudApplication
@EnableFeignClients("com.jufan.cloud.facade")
@ComponentScan({"com.jufan.cloud.sso", "com.jufan.cloud.facade.fallback"})

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories(repositoryBaseClass = WiselyRepositoryImpl.class)
public class SSOApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SSOApp.class).web(true).run(args);
    }
    @Bean(name = "auditorAware")
    public AuditorAware<String> auditorAware() {
        return ()-> SecurityUtils.getCurrentUserUsername();
    }
}
