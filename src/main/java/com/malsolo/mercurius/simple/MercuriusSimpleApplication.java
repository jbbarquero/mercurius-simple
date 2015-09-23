package com.malsolo.mercurius.simple;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.malsolo.mercurius.simple.domain.Event;
import com.malsolo.mercurius.simple.repository.EventRepository;

@SpringBootApplication
public class MercuriusSimpleApplication {
	
	@Bean
	InitializingBean seedDatabase(EventRepository repository) {
		return () -> {
			repository.save(new Event(null, 1L, "1", "data 1", new DateTime(2015, 9, 1, 0, 0).toDate(), new Date(), null, null));
			repository.save(new Event(null, 1L, "2", "data 2", new DateTime(2015, 9, 2, 12, 0).toDate(), new Date(), null, null));
			repository.save(new Event(null, 2L, "3", "data 3", new DateTime(2015, 9, 3, 23, 59).toDate(), new Date(), null, null));
		};
	}
	
	@Bean
	CommandLineRunner exampleQuery(EventRepository repository) {
		return args -> 
			repository.findByIdType(1L).forEach(System.err::println);
	}

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
