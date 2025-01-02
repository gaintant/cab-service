package com.example.cab_location_holder.controller;

import com.example.cab_location_holder.model.CabInfo;
import com.example.cab_location_holder.model.UserInfo;
import com.example.cab_location_holder.service.CabLocationHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/find-cab")
public class FindCab {

    @Autowired
    CabLocationHolder cabLocationHolder;
    @GetMapping
    public Mono<CabInfo> findCab(@RequestBody UserInfo userInfo){
        return Mono.
    }
}
