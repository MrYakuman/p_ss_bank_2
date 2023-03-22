package com.bank.transfer.dto.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class PhoneTransferDTO extends AbstractTransferDTO {

    @NotNull(message = "phoneNumber must not be empty")
    private Long phoneNumber;

}
