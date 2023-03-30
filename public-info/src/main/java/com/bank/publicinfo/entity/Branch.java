package com.bank.publicinfo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.util.List;

@Entity
@Table(name = "branch")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    private long id;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number", unique = true)
    private long phoneNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "start_of_work")
    private LocalTime startOfWork;

    @Column(name = "end_of_work")
    private LocalTime endOfWork;

//    @OneToMany(cascade =CascadeType.ALL, mappedBy = "branch")
//    private List<Atm> atmList;

}
