package com.bank.history.Service;

import com.bank.history.DTO.HistoryDTO;

import java.math.BigInteger;


public interface HistoryService {
    HistoryDTO getHistoryById(BigInteger id);
}
