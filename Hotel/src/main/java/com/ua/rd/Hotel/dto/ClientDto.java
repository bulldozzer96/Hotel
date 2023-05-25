package com.ua.rd.Hotel.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
public class ClientDto {
    private String name;

    private List<Long> reservationsId;
    //private List<LocalDate> reservationsDate;


}
