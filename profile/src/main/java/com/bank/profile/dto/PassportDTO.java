package com.bank.profile.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PassportDTO {
    @Min(value = 4, message = "series must contain 4 digits")
    @Max(value = 4, message = "series must contain 4 digits")
    int series;

    @Min(value = 5, message = "number must contain 6 digits")
    @Max(value = 6, message = "number must contain 6 digits")
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

    @Min(value = 6, message = "division code must contain 6 digits")
    @Max(value = 6, message = "division code must contain 6 digits")
    int divisionCode;
    LocalDate expirationDate;

    @NotNull(message = "enter the registration")
    RegistrationDTO registration;
}
