package com.bank.publicinfo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bank_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class  BankDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    private long id;

    @Column(name = "bik", unique = true)
    private long bik;

    @Column(name = "inn",unique = true)
    private long inn;

    @Column(name = "kpp",unique = true)
    private long kpp;

    @Column(name = "cor_account",unique = true)
    private int  corAccount;

    @Column(name = "city")
    private String city;

    @Column(name = "joint_stock_company")
    private  String jointStockCompany;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade =CascadeType.ALL, mappedBy = "bankDetails")
    private List<Certificate> certificates;

    public void addCertificateToBankDetails(Certificate certificate) {
        if(certificates == null) {
            certificates = new ArrayList<>();
        }
        certificates.add(certificate);
        certificate.setBankDetails(this);
    }
    @OneToMany(cascade =CascadeType.ALL, mappedBy = "bankDetails")
    private List<License> licenses;

    public void addLicenseToBankDetails(License license) {
        if(licenses == null) {
            licenses = new ArrayList<>();
        }
        licenses.add(license);
        license.setBankDetails(this);

    }

}
