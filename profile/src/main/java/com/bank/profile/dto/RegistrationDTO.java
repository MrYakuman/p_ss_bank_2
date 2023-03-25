package com.bank.profile.dto;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RegistrationDTO {
    @NotEmpty(message = "enter the country")
    @Size(min = 3, message = "name of the country cannot be shorter than 3 characters")
    String country;
    String region;
    String city;
    String district;
    String locality;
    String street;
    String houseNumber;
    String houseBlock;
    String flatNumber;
    //    @Max(value = 8, message = "index must contain 8 digits")

    @Digits(integer = 8, fraction = 0, message = "index must contain 8 digits")
            @Min(value = 8)
    Integer index;
}
