package com.bank.profile.dto;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ActualRegistrationDTO {
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

    @Range(min = 100000, max = 999999, message = "index must contain 6 digits")
    Integer index;
}
