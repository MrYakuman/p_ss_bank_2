package com.bank.antifraud.entity;

import javax.persistence.*;

@Entity
@Table(name = "suspicious_account_transfers")
public class SuspiciousAccountTransfers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "account_transfer_id")
    private long accountTransferId;

    @Column(name = "is_blocked")
    private boolean isBlocked;

    @Column(name = "is_suspicious")
    private boolean isSuspicious;

    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;


    public SuspiciousAccountTransfers(long id, long accountTransferId, boolean isBlocked, boolean isSuspicious, String blockedReason, String suspiciousReason) {
        this.id = id;
        this.accountTransferId = accountTransferId;
        this.isBlocked = isBlocked;
        this.isSuspicious = isSuspicious;
        this.blockedReason = blockedReason;
        this.suspiciousReason = suspiciousReason;
    }

    public SuspiciousAccountTransfers() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountTransferId() {
        return accountTransferId;
    }

    public void setAccountTransferId(long accountTransferId) {
        this.accountTransferId = accountTransferId;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public boolean isSuspicious() {
        return isSuspicious;
    }

    public void setSuspicious(boolean suspicious) {
        isSuspicious = suspicious;
    }

    public String getBlockedReason() {
        return blockedReason;
    }

    public void setBlockedReason(String blockedReason) {
        this.blockedReason = blockedReason;
    }

    public String getSuspiciousReason() {
        return suspiciousReason;
    }

    public void setSuspiciousReason(String suspiciousReason) {
        this.suspiciousReason = suspiciousReason;
    }
}
