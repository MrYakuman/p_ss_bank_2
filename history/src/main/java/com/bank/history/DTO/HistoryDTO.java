package com.bank.history.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO {
    private BigInteger id;
    private BigInteger transferAuditId;
    private BigInteger profileAuditId;
    private BigInteger accountAuditId;
    private BigInteger antifraudAuditId;
    private BigInteger bankInfoAuditId;
    private BigInteger authAuditId;
}
