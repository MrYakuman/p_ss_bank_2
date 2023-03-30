package com.bank.publicinfo.dto;

import com.bank.publicinfo.entity.Certificate;
import com.bank.publicinfo.entity.License;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDetailsDTO {

    private long id;

    private long bik;

    private long inn;

    private long kpp;

    private int  corAccount;

    private String city;

    private  String jointStockCompany;

    private String name;

    private List<Certificate> certificates;

    private List<License> licenses;

}
