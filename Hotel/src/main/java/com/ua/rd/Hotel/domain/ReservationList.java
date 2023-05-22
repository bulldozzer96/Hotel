package com.ua.rd.Hotel.domain;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate checkIn;
    @Column
    private LocalDate checkOut;

    @Column
    private String roomName;

    @Column
    private Long occupiedBy;





}
