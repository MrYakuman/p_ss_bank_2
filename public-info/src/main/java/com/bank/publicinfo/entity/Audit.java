package com.bank.publicinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Audit {

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "entity_type")
    @NotBlank
    private  String entityType;

    @Column(name = "operation_type")
    @NotBlank
    private  String operationType;

    @Column(name = "created_by")
    @NotBlank
    private  String createdBy;

    @Column(name = "modified_by")
    private  String modifiedBy;

    @Column(name = "created_at")
    @NotBlank
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private  Timestamp modifiedAt;

    @Column(name = "new_entity_json")
    private String newEntityJson;

    @Column(name = "entity_json")
    @NotBlank
    private String entityJson;


}
