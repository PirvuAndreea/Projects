package com.ps.Magazin;

import com.ps.Magazin.model.*;
import com.ps.Magazin.repository.*;
import com.ps.Magazin.service.ParfumService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import lombok.Builder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
//pt dependinta in alt modul//@ComponentScan(basePackages = "com.ps.Magazin")
public class MagazinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagazinApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ComandaRepository comandaRepository, ParfumRepository parfumRepository, ProdusComandaRepository produsComandaRepository, ReviewRepository reviewRepository, UserRepository userRepository, ParfumService parfumService) {
		return args -> {

			/*List<Review> listaReview = new ArrayList<>();
			Review review1 = new Review(null,"Andreea", "Super", LocalDate.now());
			Review review2 = new Review(null,"Paul", "Mi l-a cumparat mama", LocalDate.now());
			List<Review> listaReview2 = new ArrayList<>();
			Review review3 = new Review(null,"Denisa", "Imi place!",LocalDate.now());
			Review review4 = new Review(null,"Ana", "Foarte frumos site-ul tau!",LocalDate.now());
			listaReview.add(review1);
			listaReview.add(review2);
			listaReview2.add(review3);
			listaReview2.add(review4);
			reviewRepository.saveAll(listaReview);
			reviewRepository.saveAll(listaReview2);
			Parfum parfum1 = new Parfum(null, "Parfum1","Producator1", 2000, "Romania" , "Femeie", "continut", "descriere",100.0f, 100, "apa de parfum", listaReview2 );
			Parfum parfum2 = new Parfum(null, "Sauvage","Cristian Dior", 2000, "Romania" , "Barbat", "continut1", "descriere1",100.0f, 100, "apa de toaleta", listaReview);
			Parfum parfum3 = new Parfum(null, "Good girl","Carolina", 2000, "Romania" , "Femeie", "continut1", "descriere1",100.0f, 100, "apa de toaleta", null);
			parfumRepository.save(parfum1);
			parfumRepository.save(parfum2);
			parfumRepository.save(parfum3);
			ProdusComanda produscom1 = new ProdusComanda(null,100.0f,1, parfum1);
			ProdusComanda produscom2 = new ProdusComanda(null,100.0f,1, parfum2);
			ProdusComanda produscom3 = new ProdusComanda(null,100.0f,1, parfum3);
			List<ProdusComanda> listaComanda1 = new ArrayList<>();
			listaComanda1.add(produscom1);
			listaComanda1.add(produscom2);
			List<ProdusComanda> listaComanda2 = new ArrayList<>();
			listaComanda2.add(produscom3);
			produsComandaRepository.saveAll(listaComanda1);
			produsComandaRepository.saveAll(listaComanda2);
			User user1 = new User(null, "Andreea","123", "apirvu99@yahoo.ro", "012", RolUser.ADMIN);
			User user2 = new User(null, "Paul","1234", "paul@yahoo.com", "123", RolUser.USER);
			User user3 = new User(null, "Denisa","1234", "denisa@yahoo.com", "1234", RolUser.USER);
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			Comanda comanda1=new Comanda(null,120.0f, LocalDate.now(),"Paul", "Vlasa", "Cluj", "Buna Ziua", "paul@yahoo.com", "04562221",727200,listaComanda1 );
			Comanda comanda2=new Comanda(null,100.0f, LocalDate.now(),"Denisa", "Naica", "Dezmir", "nu stiu", "denisa@yahoo.com", "01261622",568552,listaComanda2 );
			comandaRepository.save(comanda1);
			comandaRepository.save(comanda2);

			System.out.println("Parfumuri: ");
			parfumRepository.findAll().forEach(System.out::println);
			System.out.println("Review-uri: ");
			reviewRepository.findAll().forEach(System.out::println);
			System.out.println("Comanda: ");
			comandaRepository.findAll().forEach(System.out::println);
			System.out.println("Produse comanda: ");
			produsComandaRepository.findAll().forEach(System.out::println);
			System.out.println("Useri: ");
			userRepository.findAll().forEach(System.out::println);*/
			//System.out.println(parfumRepository.findFirstByNumeparfum("Sauvage"));
			//System.out.println(parfumRepository.findFirstByCantitate(100));
			//parfumRepository.delete(parfum1);
			//reviewRepository.delete(review1);

			//mai bun in aplicatii mari
		//	ProdusComanda produsComanda= new ProdusComanda().builder().id(null).total(100.0f).cantitate(1).parfum(null).build();
		//	produsComandaRepository.save(produsComanda);

			/*Parfum parfum1 = new Parfum(null, "Parfum1","Producator1", 2000, "Romania" , "Femeie", "continut", "descriere",100.0f, 100, "apa de parfum", null );
			Parfum parfum2 = new Parfum(null, "Sauvage","Cristian Dior", 2000, "Romania" , "Barbat", "continut1", "descriere1",100.0f, 100, "apa de toaleta", null);
			Parfum parfum3 = new Parfum(null, "Good girl","Carolina", 2000, "Romania" , "Femeie", "continut1", "descriere1",100.0f, 100, "apa de toaleta", null);
			parfumRepository.save(parfum1);
			parfumRepository.save(parfum2);
			parfumRepository.save(parfum3);
			System.out.println(parfumService.findbyId(1L));*/

			User user1 = new User(null, "Andreea","123", "apirvu99@yahoo.ro", "012", RolUser.ADMIN);
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedPassword = encoder.encode(user1.getPassword());
			user1.setPassword(encodedPassword);
			List<Review> listaReview = new ArrayList<>();
			Review review1 = new Review(null,"Andreea", "Super", LocalDate.now());
			Review review2 = new Review(null,"Paul", "Mi l-a cumparat mama", LocalDate.now());
			List<Review> listaReview2 = new ArrayList<>();
			Review review3 = new Review(null,"Denisa", "Imi place!",LocalDate.now());
			Review review4 = new Review(null,"Ana", "Foarte frumos site-ul tau!",LocalDate.now());
			listaReview.add(review1);
			listaReview.add(review2);
			listaReview2.add(review3);
			listaReview2.add(review4);
			reviewRepository.saveAll(listaReview);
			reviewRepository.saveAll(listaReview2);
			Parfum parfum1 = new Parfum(null, "Parfum1","Producator1", 2000, "Romania" , "Femeie", "continut", "descriere",100.0f, 100, "apa de parfum", listaReview );
			Parfum parfum2 = new Parfum(null, "Sauvage","Cristian Dior", 2000, "Romania" , "Barbat", "continut1", "descriere1",100.0f, 100, "apa de toaleta", listaReview2);
			Parfum parfum3 = new Parfum(null, "Good girl","Carolina", 2000, "Romania" , "Femeie", "continut1", "descriere1",100.0f, 100, "apa de toaleta", null);
			parfumRepository.save(parfum1);
			parfumRepository.save(parfum2);
			parfumRepository.save(parfum3);
			ProdusComanda produscom1 = new ProdusComanda(null,100.0f,1, parfum1);
			ProdusComanda produscom2 = new ProdusComanda(null,100.0f,1, parfum2);
			ProdusComanda produscom3 = new ProdusComanda(null,100.0f,1, parfum3);

			List<ProdusComanda> listaComanda1 = new ArrayList<>();

			listaComanda1.add(produscom1);
			listaComanda1.add(produscom2);

			produsComandaRepository.save(produscom1);
			produsComandaRepository.save(produscom2);
			Comanda comanda1=new Comanda(null,120.0f, LocalDate.now(),"Paul", "Vlasa", "Cluj", "Buna Ziua", "paul@yahoo.com", "04562221",727200,listaComanda1 );
			comandaRepository.save(comanda1);


			List<ProdusComanda> listaComanda2 = new ArrayList<>();
			listaComanda2.add(produscom3);
			produsComandaRepository.saveAll(listaComanda2);

			Comanda comanda2=new Comanda(null,100.0f, LocalDate.now(),"Denisa", "Naica", "Dezmir", "nu stiu", "denisa@yahoo.com", "01261622",568552,listaComanda2 );

			//

			comandaRepository.save(comanda2);


			//User user2 = new User(null, "Andreea2","123", "apirvu99@yahoo.ro", "012", RolUser.USER);
			//User user3 = new User(null, "Andreea2","123", "apirvu99@yahoo.ro", "012", RolUser.USER);
			//List<User> users = new ArrayList<>();
		    userRepository.save(user1);


			//users.add(user2);
			//users.add(user3);
			//userRepository.saveAll(users);
			//List<User> users2 = new ArrayList<>();
			//users2=userRepository.findAll();
			//userRepository.extractLastRol(userRepository.extractMaxID(users));
			//System.out.println(userRepository.extractLastRol(userRepository.extractMaxID(users2)));








		};
	}

}
