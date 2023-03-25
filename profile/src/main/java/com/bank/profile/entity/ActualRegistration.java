package com.bank.profile.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "actual_registration")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Schema(name = "ActualRegistration", description = "Адрес фактического проживания клиента.")
public class ActualRegistration {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "country",
            length = 40)
    String country;

    @Column(name = "region",
            length = 160)
    String region;

    @Column(name = "city",
            length = 160)
    String city;

    @Column(name = "district",
            length = 160)
    String district;

    @Column(name = "locality",
            length = 230)
    String locality;

    @Column(name = "street",
            length = 230)
    String street;

    @Column(name = "house_number",
            length = 20)
    String houseNumber;

    @Column(name = "house_block",
            length = 20)
    String houseBlock;

    @Column(name = "flat_number",
            length = 40)
    String flatNumber;

    @Column(name = "index")
    int index;
}
