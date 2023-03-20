package com.bank.profile.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "registration")
@Data
@Schema(name = "Registration", description = "Данные о регистрации клиента.")
public class Registration {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "country",
            length = 166)
    @NotBlank
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
    @NotBlank
    int index;
}