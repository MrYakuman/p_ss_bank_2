package com.bank.account.entity;

import lombok.*;
import lombok.experimental.Accessors;


import javax.persistence.*;
import java.text.DecimalFormat;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Accessors(chain = true)
@Table(name = "account_details", schema = "account",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"account_number", "bank_details_id"})})
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Getter
    private long id;
    @Column
    @Getter
    private long passport_id;

    @Column
    @Getter
    private long account_number;

    @Column
    @Getter
    private long bank_details_id;

    @Column(precision = 20, scale = 2)
    private double money;

    @Column
    private boolean negative_balance;

    @Column
    @Getter
    private long profile_id;

    public boolean isNegative_balance() {
        if (money >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public double getMoney() {
        return Math.round(money * 100.00) / 100.00;
    }
}