package com.bank.profile.dto;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PassportDTO {

    @Range(min = 1000, max = 9999, message = "series must contain 4 digits")
    int series;

    @Range(min = 100000, max = 999999, message = "number must contain 6 digits")
    int number;

    @NotEmpty(message = "enter the last name")
    String lastName;

    @NotEmpty(message = "enter the first name")
    String firstName;

    String middleName;

    @NotEmpty(message = "enter the gender")
    String gender;

    @NotNull(message = "enter the birth date")
    LocalDate birthDate;

    @NotEmpty(message = "enter the birth place")
    String birthPlace;

    @NotEmpty(message = "enter the issued by")
    String issuedBy;

    @NotNull(message = "enter the date of issue")
    LocalDate dateOfIssue;

    @Range(min = 100000, max = 999999, message = "division code must contain 6 digits")
    int divisionCode;
    LocalDate expirationDate;

    @NotNull(message = "enter the registration")
    @Valid
    RegistrationDTO registration;
}
