package com.bank.antifraud.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="audit")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "entity_type")
    private String entity_type;

    @Column(name = "operation_type")
    private String operation_type;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "modified_by")
    private String modified_by;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "modified_at")
    private LocalDateTime modified_at;

    @Column(name = "new_entity_json")
    private String new_entity_json;

    @Column(name = "entity_json")
    private String entity_json;

    public Audit(String entity_type, String operation_type, String created_by, String modified_by, LocalDateTime created_at, LocalDateTime modified_at, String new_entity_json, String entity_json) {
        this.entity_type = entity_type;
        this.operation_type = operation_type;
        this.created_by = created_by;
        this.modified_by = modified_by;
        this.created_at = created_at;
        this.modified_at = modified_at;
        this.new_entity_json = new_entity_json;
        this.entity_json = entity_json;
    }

    public Audit() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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