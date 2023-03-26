package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.exception.BankDetailsNotFoundException;
import com.bank.publicinfo.repository.BankDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BankDetailsServiceImpl implements BankDetailsService{

    private final BankDetailsRepository bankDetailsRepository;

    public BankDetailsServiceImpl(BankDetailsRepository bankDetailsRepository) {
        this.bankDetailsRepository = bankDetailsRepository;
    }

    @Override
    @Transactional
    public List<BankDetails> getAllBankDetails() {
        return bankDetailsRepository.findAll();
    }

    @Override
    @Transactional
    public BankDetails getBankDetailsById(long id) {
        Optional<BankDetails> foundBankDetails = bankDetailsRepository.findById(id);
        return foundBankDetails.orElseThrow(() -> new BankDetailsNotFoundException("There is no entity with this id"));
    }

    @Override
    @Transactional
    public BankDetails save(BankDetails bankDetails) {
        return bankDetailsRepository.save(bankDetails);
    }

    @Override
    @Transactional
    public void deleteBankDetailsById(long id) {
        bankDetailsRepository.deleteById(id);
    }
}
