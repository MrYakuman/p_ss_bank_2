package com.bank.antifraud.dto;

import java.time.LocalDateTime;

public class AuditDTO {
    private String entity_type;

    private String operation_type;

    private String created_by;

    private String modified_by;

    private LocalDateTime created_at;

    private LocalDateTime modified_at;

    private String new_entity_json;

    private String entity_json;

    public String getEntity_type() {
        return entity_type;
    }

    public void setEntity_type(String entity_type) {
        this.entity_type = entity_type;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }

    public String getNew_entity_json() {
        return new_entity_json;
    }

    public void setNew_entity_json(String new_entity_json) {
        this.new_entity_json = new_entity_json;
    }

    public String getEntity_json() {
        return entity_json;
    }

    public void setEntity_json(String entity_json) {
        this.entity_json = entity_json;
    }
}
