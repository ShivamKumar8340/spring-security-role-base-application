package com.sunglowsys.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "code",nullable = false)
    private String code;

    @NotNull
    @Column(name = "name",nullable = false)
    private String name;

    @Email
    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "mobile",nullable = false)
    private String mobile;

    @Column(name = "hotel_type",nullable = false)
    private String hotelType;
}
