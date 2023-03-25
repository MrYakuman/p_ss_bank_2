package com.bank.profile.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AuditDTO {
    @NotEmpty(message = "enter the entity type")
    String entityType;

    @NotEmpty(message = "enter the operation type")
    String operationType;
    String createdBy;
    LocalDateTime createdAt;
    String modifiedBy;
    LocalDateTime modifiedAt;
    String newEntityJson;

    @NotEmpty(message = "enter the entity json")
    String entityJson;
}
