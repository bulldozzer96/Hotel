package com.ua.rd.Hotel.dto;
import com.ua.rd.Hotel.domain.ReservationList;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Data
@Builder
public class ReservationListDto {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String roomName;
    private String clientName;



}
