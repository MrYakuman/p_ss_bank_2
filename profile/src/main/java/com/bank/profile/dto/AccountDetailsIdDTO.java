package com.bank.profile.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AccountDetailsIdDTO {
    int accountId;
    ProfileDTO profile;
}
