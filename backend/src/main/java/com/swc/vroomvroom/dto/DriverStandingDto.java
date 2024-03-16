package main.java.com.swc.vroomvroom.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class DriverStandingDto {
    private int position;
    private String driverName;
    private int points;
    private String time;
}
