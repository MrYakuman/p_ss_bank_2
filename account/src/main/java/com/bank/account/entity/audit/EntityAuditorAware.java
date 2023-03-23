package com.bank.account.entity.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class EntityAuditorAware implements AuditorAware {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Litvinova Viktoriia");
    }
}
