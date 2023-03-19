package com.bank.history.Service;

import com.bank.history.DTO.HistoryDTO;
import com.bank.history.Entity.History;

import java.math.BigInteger;
import java.util.List;

public interface HistoryService {
    HistoryDTO getHistoryById(BigInteger id);
}
