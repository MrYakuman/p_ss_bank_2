package com.bank.publicinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDTO {

    private long id;

    private  String entityType;

    private  String operationType;

    private  String createdBy;

    private  String modifiedBy;

    private Timestamp createdAt;

    private  Timestamp modifiedAt;

    private String newEntityJson;

    private String entityJson;
}
