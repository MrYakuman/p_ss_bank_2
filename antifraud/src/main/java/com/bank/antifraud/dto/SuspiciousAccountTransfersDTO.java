package com.bank.antifraud.dto;

public class SuspiciousAccountTransfersDTO {
    private long accountTransferId;

    private boolean isBlocked;

    private boolean isSuspicious;

    private String blockedReason;

    private String suspiciousReason;

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
