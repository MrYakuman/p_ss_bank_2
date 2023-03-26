package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.BankDetails;
import io.micrometer.core.instrument.Tags;

import java.util.List;

public interface BankDetailsService {
    List<BankDetails> getAllBankDetails();

    BankDetails getBankDetailsById(long id);

    BankDetails save(BankDetails bankDetails);

    void deleteBankDetailsById(long id);
}
