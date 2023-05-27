package com.ua.rd.Hotel.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;


import java.util.List;


@Data
@Table(name = "room",uniqueConstraints = { @UniqueConstraint(columnNames = { "name"}) })
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @Column
    private int floor;


    @ManyToOne
    @JoinColumn(name = "roomStatus_id")
    private RoomStatus roomStatusId;


    @OneToMany(mappedBy = "roomId")
    private List<ReservationList> reservationList;



}
