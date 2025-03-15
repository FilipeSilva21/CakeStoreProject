package com.CakeStore.models;

import com.CakeStore.models.enums.CakeType;
import com.CakeStore.models.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate validateDate;

    @Column(name = "saleDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate saleDate;

    @Column(name = "paymentMethod")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties("cakes")
    public Client clientId;
}
