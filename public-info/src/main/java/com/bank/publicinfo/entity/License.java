package com.bank.publicinfo.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "license")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    private long id;

    @Column(name = "photo")
    private String photo;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "bank_details_id")
    private BankDetails bankDetails;
}
