package com.malsolo.mercurius.simple;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.malsolo.mercurius.simple.domain.Event;
import com.malsolo.mercurius.simple.repository.EventRepository;

@SpringBootApplication
@EnableConfigurationProperties
public class MercuriusSimpleApplication {

	@Bean
	InitializingBean seedDatabase(EventRepository repository) {
		return () -> {
			repository.save(new Event(null, 1L, "1", "data 1", new DateTime(
					2015, 9, 1, 0, 0).toDate(), new Date(), null, null));
			repository.save(new Event(null, 1L, "2", "data 2", new DateTime(
					2015, 9, 2, 12, 0).toDate(), new Date(), null, null));
			repository.save(new Event(null, 2L, "3", "data 3", new DateTime(
					2015, 9, 3, 23, 59).toDate(), new Date(), null, null));
		};
	}

	@Bean
	CommandLineRunner exampleQuery(EventRepository repository) {
		return args -> repository.findByIdType(1L).forEach(System.err::println);
	}

	@Value("${configuration.projectName}")
	void setProjectName(String projectName) {
		System.err.printf("setting project name: %s%n", projectName);
	}

	@Autowired
	void setEnvironment(Environment env) {
		System.err.printf("setting environment: %s: %s%n",
				env.getProperty("configuration.projectName"),
				env.getProperty("configuration.projectDescription")
				);
		System.err.printf("ENVIRONMENT: %s%n", env.getProperty("app.environment"));
	}

	@Autowired
	void setConfigurationProjectProperties(ConfigurationProjectProperties cp) {
		System.err.printf("configurationProjectProperties.projectName = %s: %s%n",
				cp.getProjectName(), cp.getProjectDescription());
	}

	public static void main(String[] args) {
//		SpringApplication.run(MercuriusSimpleApplication.class, args);
		SpringApplication application = new SpringApplication(MercuriusSimpleApplication.class);
//		application.setWebEnvironment(false);
		application.run(args);
//		System.out.println(">>>>> RUNNING!");
	}

	// @Bean
	// CommandLineRunner runner(EventRepository er) {
	// return (args) -> {
	// er.save(new Event(null, 1L, "1", "DATA", new Date(), new Date(), null,
	// 0));
	//
	// er.findAll().forEach(System.out::println);
	// };
	// }
}
