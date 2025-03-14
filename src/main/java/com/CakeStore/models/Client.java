package com.CakeStore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tbClients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "cakeId")
    @JsonIgnoreProperties("cakes")
    private Cake cakesBought;
}
