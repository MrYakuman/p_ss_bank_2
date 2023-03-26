package com.bank.publicinfo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "certificate")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Certificate {

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

