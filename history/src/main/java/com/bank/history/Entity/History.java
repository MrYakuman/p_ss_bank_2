package com.bank.history.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name = "transfer_audit_id")
    private BigInteger transferAuditId;
    @Column(name = "profile_audit_id")
    private BigInteger profileAuditId;
    @Column(name = "account_audit_id")
    private BigInteger accountAuditId;
    @Column(name = "anti_fraud_audit_id")
    private BigInteger antifraudAuditId;
    @Column(name = "public_bank_info_audit_id")
    private BigInteger bankInfoAuditId;
    @Column(name = "authorization_audit_id")
    private BigInteger authAuditId;
}
