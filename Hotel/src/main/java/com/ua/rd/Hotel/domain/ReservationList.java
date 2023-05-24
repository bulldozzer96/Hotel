package com.ua.rd.Hotel.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import lombok.*;
import com.ua.rd.Hotel.domain.Clients;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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

    @Column(name = "checkIn")
    @Temporal(TemporalType.DATE)

    private LocalDate checkIn;

    @Column(name = "checkOut")
    @Temporal(TemporalType.DATE)

    private LocalDate checkOut;

    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Clients clients_id;//fix name

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;

}




