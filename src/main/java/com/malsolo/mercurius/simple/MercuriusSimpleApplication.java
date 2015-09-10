package com.malsolo.mercurius.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MercuriusSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MercuriusSimpleApplication.class, args);
    }

//	@Bean
//	CommandLineRunner runner(EventRepository er) {
//		return (args) -> {
//			er.save(new Event(null, 1L, "1", "DATA", new Date(), new Date(), null, 0));
//			
//			er.findAll().forEach(System.out::println);
//		};
//	}
}
