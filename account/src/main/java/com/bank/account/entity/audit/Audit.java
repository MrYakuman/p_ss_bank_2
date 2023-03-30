package com.bank.account.entity.audit;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "audit", schema = "account")
@Accessors(chain = true)
public class Audit extends Auditable implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 40)
    private String entity_type;
    @Column(length = 255)
    private String operation_type;
    @Column(nullable = true)
    private String new_entity_json;
    @Column
    private String entity_json;
}

