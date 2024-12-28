package com.example.cab_location_holder;

import com.example.cab_location_holder.Consumer.cabLocationHolder;
import com.example.cab_location_holder.model.CabLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class KafkaTestRunner implements CommandLineRunner {

    @Autowired
    private cabLocationHolder cabLocationHolder;
    @Autowired
    private KafkaProducer producer;

    @Override
    public void run(String... args) throws Exception {
        // Sending test messages
        for (int i = 1; i <= 15; i++) {
            producer.sendMessage(CabLocation.builder()
                    .cabID(String.valueOf(i))
                    .isAvailable(true)
                    .latitude(Math.random())
                    .longitude(Math.random())
                    .build());
        }
        System.out.println("Messages sent. Check consumer logs for output.");
//        cabLocationHolder.findNearestCabs(Math.random(), Math.random(), 1);
    }
}
