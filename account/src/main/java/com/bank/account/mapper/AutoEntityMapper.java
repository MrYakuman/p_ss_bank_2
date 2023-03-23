package com.bank.account.mapper;

import com.bank.account.dto.AccountDetailsDto;
import com.bank.account.dto.AuditDto;
import com.bank.account.entity.AccountDetails;
import com.bank.account.entity.audit.Audit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEntityMapper {
    AutoEntityMapper MAPPER = Mappers.getMapper(AutoEntityMapper.class);
    AuditDto mapToAuditDto(Audit account);
    Audit mapToAudit(AuditDto accountDto);
    AccountDetailsDto mapToAccountDto(AccountDetails account);
    AccountDetails mapToAccount(AccountDetailsDto accountDto);
}
