package com.bank.publicinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtmDTO {

    private long id;

    @NotBlank
    private String address;

    private boolean allHours;

    private LocalTime startOfWork;

    private LocalTime endOfWork;

}
