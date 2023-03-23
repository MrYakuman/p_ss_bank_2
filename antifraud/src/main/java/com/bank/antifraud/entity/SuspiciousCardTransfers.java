package com.bank.antifraud.entity;

import javax.persistence.*;

@Entity
@Table(name = "suspicious_card_transfer" )
public class SuspiciousCardTransfers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "card_transfer_id")
    private long cardTransferId;

    @Column(name = "is_blocked")
    private boolean isBlocked;

    @Column(name = "is_suspicious")
    private boolean isSuspicious;

    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;

    public SuspiciousCardTransfers(long id, long cardTransferId, boolean isBlocked, boolean isSuspicious, String blockedReason, String suspiciousReason) {
        this.id = id;
        this.cardTransferId = cardTransferId;
        this.isBlocked = isBlocked;
        this.isSuspicious = isSuspicious;
        this.blockedReason = blockedReason;
        this.suspiciousReason = suspiciousReason;
    }

    public SuspiciousCardTransfers() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCardTransferId() {
        return cardTransferId;
    }

    public void setCardTransferId(long cardTransferId) {
        this.cardTransferId = cardTransferId;
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
