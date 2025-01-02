package com.example.cab_location_holder.service;

public interface CabLocationHolder {
    String findNearestCabs(double longitude, double latitude, double radius);
}
