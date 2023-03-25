package com.bank.profile.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity(name = "passport")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Schema(name = "Passport", description = "Данные паспорта клиента.")
public class Passport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "series")
    int series;
    @Column(name = "number")
    int number;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "middle_name")
    String middleName;
    @Column(name = "gender",
            length = 3)
    String gender;
    @Column(name = "birth_date")
    LocalDate birthDate;
    @Column(name = "birth_place",
            length = 480)
    String birthPlace;
    @Lob
    @Column(name = "issued_by",
            columnDefinition = "TEXT")
    String issuedBy;
    @Column(name = "date_of_issue")
    LocalDate dateOfIssue;
    @Column(name = "division_code")
    int divisionCode;
    @Column(name = "expiration_date")
    LocalDate expirationDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registration_id")
    Registration registrationId;
}
