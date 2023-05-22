package com.ua.rd.Hotel.domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Optional;


@Data
@Table
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

    @OneToMany(mappedBy = "clients_id")
    private List<ReservationList> reservationList;



}
