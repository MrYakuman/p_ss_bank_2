package com.bank.account.entity.audit;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Table (name = "audit", schema = "account")
@Accessors(chain = true)
public abstract class Auditable {
    @CreatedBy
    @Column
    private String created_by;

    @CreatedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @LastModifiedBy
    @Column (nullable = true)
    protected String modified_by;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (nullable = true)
    @LastModifiedDate
    protected Date modified_at;
}
