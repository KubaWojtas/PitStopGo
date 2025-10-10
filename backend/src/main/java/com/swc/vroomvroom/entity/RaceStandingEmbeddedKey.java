package com.swc.vroomvroom.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RaceStandingEmbeddedKey implements Serializable {
    UUID driverId;
    UUID raceId;
}
