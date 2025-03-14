package com.CakeStore.models;

import com.CakeStore.models.enums.CakeType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tbCakes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cakeId")
    private Long cakeId;

    @Column(name = "cakeType")
    @Enumerated(EnumType.STRING)
    private CakeType cakeType;

    @Column(name = "validateDate")
    private int validateDate;

    @Column(name = "saleDate")
    private int saleDate;

    @OneToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties("cakes")
    private Client buyer;
}
