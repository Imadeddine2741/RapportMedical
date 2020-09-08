package org.creditMutuel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RapportMedical {
	public static void main(String[] args) {
		SpringApplication.run(RapportMedical.class, args);
	}
}