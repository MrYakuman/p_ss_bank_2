package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.AtmDTO;
import com.bank.publicinfo.entity.Atm;
import org.springframework.stereotype.Service;


import java.util.List;

public interface AtmService {

    List<Atm> getAllAtm();
    Atm save(Atm atm);
    void deleteAtmById(long id);
    Atm getAtmById(long id);
}
