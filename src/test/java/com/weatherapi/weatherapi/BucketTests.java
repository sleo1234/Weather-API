package com.weatherapi.weatherapi;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
public class BucketTests {

	@Test
	public void testBucket() {
		Refill refill = Refill.intervally(10, Duration.ofMinutes(1));
		Bandwidth limit = Bandwidth.classic(10, refill);
		Bucket bucket = Bucket.builder()
		    .addLimit(limit)
		    .build();

		for (int i = 1; i <= 10; i++) {
			
		    assertThat((bucket.tryConsume(1)));
		}
		assertThat(bucket.tryConsume(1));
	}
}
