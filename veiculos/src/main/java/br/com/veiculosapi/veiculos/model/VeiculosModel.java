package br.com.veiculosapi.veiculos.model;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "veiculos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeiculosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "modelo", length = 45)
    private String modelo;

    @Column(name = "placa", length = 45)
    private String placa;
}
