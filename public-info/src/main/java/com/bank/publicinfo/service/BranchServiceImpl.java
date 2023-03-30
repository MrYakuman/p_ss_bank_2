package com.bank.publicinfo.service;

import com.bank.publicinfo.entity.Branch;
import com.bank.publicinfo.exception.BranchNotFoundException;
import com.bank.publicinfo.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService{

    @Autowired
    BranchRepository branchRepository;
    @Override
    @Transactional
    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    @Override
    @Transactional
    public Branch getBranchById(long id) {
        Optional<Branch> foundBranch = branchRepository.findById(id);
        return  foundBranch.orElseThrow(() -> new BranchNotFoundException("There is no entity with this id"));
    }

    @Override
    @Transactional
    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    @Transactional
    public void deleteBranchById(long id) {
        branchRepository.deleteById(id);
    }
}
