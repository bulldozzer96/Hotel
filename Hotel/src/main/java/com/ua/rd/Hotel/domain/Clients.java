package com.ua.rd.Hotel.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"phone", "passport"})})
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
    @Column
    private String sex;


    @OneToMany(mappedBy = "clientsId")
    private List<ReservationList> reservationList;


}
