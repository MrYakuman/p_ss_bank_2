package com.bank.profile.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity(name = "profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Schema(name = "Profile", description = "Банковский профиль клиента.")
public class Profile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "phone_number")
    @Min(value = 6, message = "the phone number cannot be shorter than 6")
    long phoneNumber;

    @Column(name = "email")
    String email;

    @Column(name = "name_on_card")
    String nameOnCard;

    @Column(name = "inn",
            unique = true)
    long inn;

    @Column(name = "snils",
            unique = true)
    long snils;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    Passport passportId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actual_registration_id")
    ActualRegistration actualRegistrationId;

}
