package com.bank.profile.entity.audit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Schema(name = "Auditable", description = "Класс, наследующийся от AuditingEntityListener.class, для реализации сбора и сохранения информации об объектах.")
public abstract class Auditable<T> {
    @Column(name = "created_by")
    @CreatedBy
    protected String createdBy;

    @Column(name = "created_at",
            columnDefinition = "TIMESTAMP")
    @CreatedDate
    protected LocalDateTime createdAt;

    @Column(name = "modified_by")
    @LastModifiedBy
    protected T modifiedBy;

    @Column(name = "modified_at",
            columnDefinition = "TIMESTAMP")
    @LastModifiedDate
    protected LocalDateTime modifiedAt;

}
