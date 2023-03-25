package com.bank.profile.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(value = 8, message = "index must contain 8 digits")
    @Max(value = 8, message = "index must contain 8 digits")
    int index;
}
