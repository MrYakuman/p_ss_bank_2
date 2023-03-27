package com.bank.publicinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO {

    private long id;

    private String address;

    private BigInteger phoneNumber;

    private String city;

    private LocalTime startOfWork;

    private LocalTime endOfWork;

}
