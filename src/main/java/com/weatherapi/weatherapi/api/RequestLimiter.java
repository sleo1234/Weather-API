package com.weatherapi.weatherapi.api;



import java.time.Duration;

import org.springframework.web.bind.annotation.RestController;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;


@RestController
public class RequestLimiter {

	

    private  Bucket bucket;

    public void WeatherLimiterApi(int noOfRequests,int minutes) {
        Bandwidth limit = Bandwidth.classic(noOfRequests, Refill.greedy(20,Duration.ofMinutes(minutes) ));
        this.bucket = Bucket.builder()
            .addLimit(limit)
            .build();
    }
}
