package com.bank.account.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.text.DecimalFormat;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AccountDetailsDto {
    @Getter
    private long id;
    @Getter
    private long passport_id;
    @Getter
    private long account_number;
    @Getter
    private long bank_details_id;

    private double money;
    private boolean negative_balance;
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

    @Override
    public String toString() {
        return "{ " +
                "id: " + id +
                ", passport_id: " + passport_id +
                ", account_number: " + account_number +
                ", bank_details_id: " + bank_details_id +
                ", money: " + money +
                ", negative_balance: " + negative_balance +
                ", profile_id: " + profile_id +
                " }";
    }
}
