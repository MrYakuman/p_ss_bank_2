package com.bank.profile.service.serviceInterface;

import com.bank.profile.entity.AccountDetailsId;

import java.util.List;

public interface AccountDetailsIdService {
    boolean saveAccountDetailsId(AccountDetailsId accountDetailsId);

    AccountDetailsId findAccountDetailsIdById(long accountDetailsIdId);

    boolean editAccountDetailsId(Long id, AccountDetailsId accountDetailsId);

    boolean deleteAccountDetailsId(long accountDetailsIdId);

    List<AccountDetailsId> getAllAccountDetailsId();
}
