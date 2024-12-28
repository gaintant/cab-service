package com.example.cab_location_holder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CabLocation {
    @JsonProperty("cabID")
    private String cabID;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("isAvailable")
    private boolean isAvailable;

    @JsonProperty("timestamp")
    private String timestamp;
}
