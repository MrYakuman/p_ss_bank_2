package com.bank.antifraud.dto;

public class Suspicious_card_transfersDTO {
    private long card_transfer_id;

    private boolean is_blocked;

    private boolean is_suspicious;

    private String blocked_reason;

    private String suspicious_reason;

    public long getCard_transfer_id() {
        return card_transfer_id;
    }

    public void setCard_transfer_id(long card_transfer_id) {
        this.card_transfer_id = card_transfer_id;
    }

    public boolean isIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    public boolean isIs_suspicious() {
        return is_suspicious;
    }

    public void setIs_suspicious(boolean is_suspicious) {
        this.is_suspicious = is_suspicious;
    }

    public String getBlocked_reason() {
        return blocked_reason;
    }

    public void setBlocked_reason(String blocked_reason) {
        this.blocked_reason = blocked_reason;
    }

    public String getSuspicious_reason() {
        return suspicious_reason;
    }

    public void setSuspicious_reason(String suspicious_reason) {
        this.suspicious_reason = suspicious_reason;
    }
}
