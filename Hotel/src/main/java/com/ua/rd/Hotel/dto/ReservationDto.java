package com.ua.rd.Hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Data
@Builder
public class ReservationDto {

    private Long roomId;
    private LocalDate checkIn;
    private Date orderDate;
    private LocalDate checkOut;
    private String roomName;
    private Long clientId;
    private String clientName;






}
