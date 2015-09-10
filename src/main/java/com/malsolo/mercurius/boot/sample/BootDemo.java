package com.malsolo.mercurius.boot.sample;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class BootDemo {
	
	public static void main(String... args) {
		SpringApplication.run(BootDemo.class, args);
	}
	
	@Bean
	CommandLineRunner runner(ReservationRepository rr) {
		return (args) -> {
			Arrays.asList("Javier,Pepe,Pepito,Don José".split(","))
				.forEach(s -> rr.save(new Reservation(s)));
			
			rr.findAll().forEach(System.out::println);
			
			rr.findByReservationName("Javier").forEach(System.out::println);
		};
	}

}

@Entity
@Data
@NoArgsConstructor
class Reservation {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String reservationName;
	
	public Reservation(String name) {
		this.reservationName = name;
	}
	
}


//interface ReservationRepository extends JpaRepository<Reservation, Long> {
//	
//	Collection<Reservation> findByReservationName(String reservationName);
//
//}
//
//@RestController
//class ReservationController {
//	
//	@Autowired
//	ReservationRepository reservationRepository;
//	
//	@RequestMapping("/reservations")
//	Collection<Reservation> reservations() {
//		return this.reservationRepository.findAll();
//	}
//	
//}

@RepositoryRestResource
interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	Collection<Reservation> findByReservationName(@Param("rn") String reservationName);

}

@Component
class ReservationResourceProcessor implements ResourceProcessor<Resource<Reservation>> {

	@Override
	public Resource<Reservation> process(Resource<Reservation> reservationResource) {
		reservationResource.add(new Link("http://s3.com/imgs/" + reservationResource.getContent().getId() + ".jpg", "profile-photo"));
		return reservationResource;
	}
	
}

@Controller
class ReservationMvcController {
	
	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping("/reservations.php")
	String reservations(Model model) {
		model.addAttribute("reservations", this.reservationRepository.findAll());
		return "reservations"; //src/main/resources/templates/
	}
	
}
