package com.ua.rd.Hotel.dto;

import com.ua.rd.Hotel.domain.Room;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Data
@Builder
public class ReservationListDto {
    private Room roomId;
    private LocalDate checkIn;
    private Date orderDate;
    private LocalDate checkOut;
    private String roomName;
    private String clientName;
    private int status;



}
