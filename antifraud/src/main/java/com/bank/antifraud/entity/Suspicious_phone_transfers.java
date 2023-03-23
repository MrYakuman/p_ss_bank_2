package com.bank.antifraud.entity;

import javax.persistence.*;

@Entity
@Table(name = "suspicious_phone_transfers")
public class Suspicious_phone_transfers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "phone_transfer_id")
    private long phone_transfer_id;

    @Column(name = "is_blocked")
    private boolean is_blocked;

    @Column(name = "is_suspicious")
    private boolean is_suspicious;

    @Column(name = "blocked_reason")
    private String blocked_reason;

    @Column(name = "suspicious_reason")
    private String suspicious_reason;

    public Suspicious_phone_transfers(long id, long phone_transfer_id, boolean is_blocked, boolean is_suspicious, String blocked_reason, String suspicious_reason) {
        this.id = id;
        this.phone_transfer_id = phone_transfer_id;
        this.is_blocked = is_blocked;
        this.is_suspicious = is_suspicious;
        this.blocked_reason = blocked_reason;
        this.suspicious_reason = suspicious_reason;
    }

    public Suspicious_phone_transfers() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhone_transfer_id() {
        return phone_transfer_id;
    }

    public void setPhone_transfer_id(long phone_transfer_id) {
        this.phone_transfer_id = phone_transfer_id;
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
