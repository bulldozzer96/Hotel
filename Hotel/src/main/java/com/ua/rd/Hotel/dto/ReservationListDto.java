package com.ua.rd.Hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Data
@Builder
public class ReservationListDto {
    private LocalDate checkIn;
    private Date orderDate;
    private LocalDate checkOut;
    private String roomName;
    private String clientName;
//    private String statusName;





}
