package com.example.cab_location_holder;

import com.example.cab_location_holder.model.CabInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC = "cab-location";

    @Autowired
    private KafkaTemplate<String, CabInfo> kafkaTemplate;

    public void sendMessage(CabInfo message) {
        System.out.println("Sending message: " + message);
        kafkaTemplate.send(TOPIC, message);
    }
}
