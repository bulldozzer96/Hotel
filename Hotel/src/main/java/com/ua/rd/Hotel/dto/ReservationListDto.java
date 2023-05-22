package com.ua.rd.Hotel.dto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class ReservationListDto {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String roomName;
    private String clientName;

}
