package com.ua.rd.Hotel.dto;

import com.ua.rd.Hotel.domain.ReservationList;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Data
@Builder
public class ReservationListDto {
    private Long id;
    private Long roomId;
    private LocalDate checkIn;
    private Date orderDate;
    private LocalDate checkOut;
    private String roomName;
    private String clientName;




}
