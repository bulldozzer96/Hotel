package com.ua.rd.Hotel.domain;
import jakarta.persistence.*;
import lombok.*;
import com.ua.rd.Hotel.domain.Clients;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private LocalDate checkIn;

    @Column
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private LocalDate checkOut;

//    @Column
//    private Long roomId;




    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Clients clients_id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;


}
