package com.ua.rd.Hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Data
@Builder
public class ReservationDto {



    private Date orderDate;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String roomName;

    private String clientName;






}
