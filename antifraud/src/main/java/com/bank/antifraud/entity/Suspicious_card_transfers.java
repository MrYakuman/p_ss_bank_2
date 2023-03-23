package com.bank.antifraud.entity;

import javax.persistence.*;

@Entity
@Table(name = "suspicious_card_transfer" )
public class Suspicious_card_transfers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "card_transfer_id")
    private long card_transfer_id;

    @Column(name = "is_blocked")
    private boolean is_blocked;

    @Column(name = "is_suspicious")
    private boolean is_suspicious;

    @Column(name = "blocked_reason")
    private String blocked_reason;

    @Column(name = "suspicious_reason")
    private String suspicious_reason;

    public Suspicious_card_transfers(long id, long card_transfer_id, boolean is_blocked, boolean is_suspicious, String blocked_reason, String suspicious_reason) {
        this.id = id;
        this.card_transfer_id = card_transfer_id;
        this.is_blocked = is_blocked;
        this.is_suspicious = is_suspicious;
        this.blocked_reason = blocked_reason;
        this.suspicious_reason = suspicious_reason;
    }

    public Suspicious_card_transfers() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
