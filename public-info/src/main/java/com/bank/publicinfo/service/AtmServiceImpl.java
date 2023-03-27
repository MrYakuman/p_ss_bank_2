package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Atm;
import com.bank.publicinfo.exception.AtmNotFoundException;
import com.bank.publicinfo.repository.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AtmServiceImpl implements AtmService{
    AtmRepository atmRepository;

    @Autowired
    public AtmServiceImpl(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    @Override
    @Transactional
    public List<Atm> getAllAtm(){
        List<Atm> atmList = atmRepository.findAll();
        return atmList;
    }

    @Override
    @Transactional
    public Atm save(Atm atm) {
        return atmRepository.save(atm);
    }

    @Override
    @Transactional
    public void deleteAtmById(long id) {
        atmRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Atm getAtmById(long id) {
        Optional<Atm> foundAtm =atmRepository.findById(id);
        return foundAtm.orElseThrow(() -> new AtmNotFoundException("There is no entity with this id"));
    }
}
