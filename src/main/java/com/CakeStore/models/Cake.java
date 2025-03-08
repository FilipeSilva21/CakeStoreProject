package com.CakeStore.models;

import com.CakeStore.models.enums.CakeType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tbCakes")
@Getter
@Setter
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cakeId")
    private Long id;

    @Column(name = "cakeType")
    @Enumerated(EnumType.STRING)
    private CakeType cakeType;

    @Column(name = "validateDate")
    private Date validateDate;

    @ManyToMany
    @
    private int sales;
}
