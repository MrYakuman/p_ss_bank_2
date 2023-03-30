package com.bank.publicinfo.mapper;


import com.bank.publicinfo.dto.BranchDTO;
import com.bank.publicinfo.entity.Branch;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BranchMapper {

    Branch toBranch(BranchDTO branchDTO);

    BranchDTO toBranchDTO(Branch branch);
}
