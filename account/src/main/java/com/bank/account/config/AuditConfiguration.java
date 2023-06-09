package com.bank.account.config;

import com.bank.account.entity.audit.EntityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditConfiguration {
    @Bean
    public AuditorAware<String> auditorAware() {
        return new EntityAuditorAware();
    }
}
