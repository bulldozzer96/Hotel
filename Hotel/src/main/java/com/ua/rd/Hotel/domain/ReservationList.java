package com.ua.rd.Hotel.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Data
@Table(name = "reservationList")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class ReservationList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "checkIn")
    @Temporal(TemporalType.DATE)
    private LocalDate checkIn;

    @Column(name = "checkOut")
    @Temporal(TemporalType.DATE)
    private LocalDate checkOut;

    @Column(name = "orderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clients_Id")
    private Clients clientsId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;

}




