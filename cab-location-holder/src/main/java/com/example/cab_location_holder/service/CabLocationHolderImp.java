package com.example.cab_location_holder.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabLocationHolderImp implements CabLocationHolder{

    private static final String GEO_KEY = "cabs";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // Add a cab location
       // Find nearest cabs within a given radius
    public String findNearestCabs(double longitude, double latitude, double radius) {
        List<GeoResult<RedisGeoCommands.GeoLocation<String>>> nearestCab = redisTemplate.opsForGeo()
                .radius(GEO_KEY,
                        new Circle(new Point(latitude, longitude), radius),
                        RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeCoordinates().includeDistance().sortAscending()
                ).getContent();
        System.out.println(String.valueOf(latitude) + " " + String.valueOf(longitude));
        if(nearestCab.isEmpty())
            return findNearestCabs(longitude, latitude, radius*2);
        return nearestCab.get(0).getContent().getName();
    }
//    @KafkaListener(topics = "cab-location", groupId = "locator", containerFactory = "kafkaListenerContainerFactory")
//    public void consume(CabInfo cabInfo) {
//        redisTemplate.opsForGeo().add(GEO_KEY,
//                new RedisGeoCommands.GeoLocation<>(cabInfo.getCabID(),
//                        new Point(cabInfo.getLongitude(), cabInfo.getLatitude())));
//        System.out.println("added to redis data:" + cabInfo);
//        System.out.println("founded cab" + findNearestCabs(Math.random(), Math.random(), 5000));
//    }
}
