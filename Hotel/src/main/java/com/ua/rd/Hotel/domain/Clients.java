package com.ua.rd.Hotel.domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Optional;


@Data
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "phone","passport"}) })
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String passport;
    @Column
    private String phone;


    @OneToMany(mappedBy = "clientsId")
    private List<ReservationList> reservationList;



}
