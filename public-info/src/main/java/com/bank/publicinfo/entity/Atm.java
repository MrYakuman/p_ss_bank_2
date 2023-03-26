package com.bank.publicinfo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;

@Entity
@Table(name = "atm")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Atm {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    private long id;

    @Column(name = "address")
    @NotBlank
    private String address;

    @Column(name = "start_of_work")
    private LocalTime startOfWork;

    @Column(name = "end_of_work")
    private LocalTime endOfWork;


    @Column(name = "all_hours")
    private boolean allHours;

   @ManyToOne()
   @JoinColumn(name = "branch_id")
   private Branch branch;
//    @Column(name = "branch_id")
//    private long branchId;
}
