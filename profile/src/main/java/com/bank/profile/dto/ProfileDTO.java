package com.bank.profile.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProfileDTO {

    @Min(value = 100000, message = "phone number cannot be shorter than 6")
    long phoneNumber;

    @Email(message = "you must specify an email address")
    String email;

    String nameOnCard;

    long inn;

    long snils;

    @NotNull(message = "it is necessary to specify the passport data")
    @Valid
    PassportDTO passport;

    @Valid
    ActualRegistrationDTO actualRegistration;
}
