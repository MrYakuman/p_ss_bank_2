package com.bank.publicinfo.service;

import com.bank.publicinfo.dto.BranchDTO;
import com.bank.publicinfo.entity.Branch;
import io.micrometer.core.instrument.Tags;

import java.util.List;

public interface BranchService {
    List<Branch> getAllBranch();

    Branch getBranchById(long id);

    Branch save(Branch branch);

    void deleteBranchById(long id);
}
