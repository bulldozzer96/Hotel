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
public class RoomStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "roomStatus_id")
    private List<Room> room;



}
