package com.ua.rd.Hotel.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoomStatusDto {
    private Long id;
    private String name;
    private List<String> rooms;
}
