package com.ua.rd.Hotel.dto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Data
@Builder
public class ReservationListDto {
    private Date checkIn;
    private Date checkOut;
    private String roomName;
    private String clientName;

}
