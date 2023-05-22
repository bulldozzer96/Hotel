package com.ua.rd.Hotel.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int price;
    @Column
    private int floor;
    @Column
    private Long occupiedBy;



    @ManyToOne
    @JoinColumn(name = "roomStatus_id")
    private RoomStatus roomStatus_id;

    @ManyToMany(mappedBy = "list_reservation")
    private List<Clients> list_reservation;


}
