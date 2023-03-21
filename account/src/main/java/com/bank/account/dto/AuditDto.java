package com.bank.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AuditDto {
    private long id;
    private String entity_type;
    private String created_by;
    private Date created_at;
    protected String modified_by;
    protected Date modified_at;
    private String operation_type;
    private String new_entity_json;
    private String entity_json;

}
