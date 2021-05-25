package com.ps.Magazin;

import com.ps.Magazin.dto.ParfumReviewAdditionDTO;
import com.ps.Magazin.dto.ProdusComandaAddParfumDTO;
import com.ps.Magazin.model.*;
import com.ps.Magazin.repository.*;
import com.ps.Magazin.service.ParfumService;
import com.ps.Magazin.service.ProdusComandaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import lombok.Builder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Blob;
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
	CommandLineRunner init(ComandaRepository comandaRepository, ParfumRepository parfumRepository, ProdusComandaRepository produsComandaRepository, ReviewRepository reviewRepository, UserRepository userRepository, ParfumService parfumService, ProdusComandaService produsComandaService) {
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

			User user1 = new User(null, "Andreea","123", "altceva@yahoo.ro", 0123,RolUser.ADMIN,false,null, null,false, false);
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedPassword = encoder.encode(user1.getPassword());
			System.out.println(encoder.matches(user1.getPassword(), encodedPassword));
			user1.setPassword(encodedPassword);



			List<Review> listaReview = new ArrayList<>();
			Review review1 = new Review(null,"Andreea", "Super", LocalDate.now());
			Review review2 = new Review(null,"Paul", "Mi l-a cumparat mama", LocalDate.now());
			List<Review> listaReview2 = new ArrayList<>();
			Review review3 = new Review(null,"Denisa", "Imi place!",LocalDate.now());
			Review review4 = new Review(null,"Ana", "Foarte frumos site-ul tau!",LocalDate.now());
			Review review5 = new Review(null,"Maria", "uau!",LocalDate.now());

			listaReview.add(review1);
			listaReview.add(review2);
			listaReview2.add(review3);
			listaReview2.add(review4);

			reviewRepository.save(review5);
			reviewRepository.saveAll(listaReview);
			reviewRepository.saveAll(listaReview2);
			Parfum parfum1 = new Parfum(null, "My way","Armani", 2020, "Romania" , "Femeie", "continut", "descriere",120.0f, 100, "apa de parfum","https://s.cdnmpro.com/276449694/p/m/6/armani-my-way~41386.jpg", false,listaReview );
			Parfum parfum2 = new Parfum(null, "Sauvage","Cristian Dior", 2000, "Romania" , "Barbat", "continut1", "descriere1",110.0f, 100, "apa de toaleta", "https://www.parfimo.ro/data/cache/thumb_min500_max1000-min500_max1000-12/products/106228/1571814437/christian-dior-sauvage-parfum-pentru-barbati-100-ml-291469.jpg",false,listaReview2);
			Parfum parfum3 = new Parfum(null, "Good girl","Carolina", 2000, "Romania" , "Femeie", "continut1", "descriere1",174.0f, 100, "apa de toaleta","https://s13emagst.akamaized.net/products/32995/32994952/images/res_62e087de00289a81ffc10cc0a95c8a2b.jpg", false,null);
			Parfum parfum4 = new Parfum(null, "Si","Armani", 2000, "Romania" , "Femeie", "continut1", "descriere1",134.0f, 100, "apa de toaleta","https://www.parfimo.ro/data/cache/thumb_min500_max1000-min500_max1000-12/products/96258/1568251427/giorgio-armani-si-apa-de-parfum-pentru-femei-100-ml-257109.jpg", false,null);

			Parfum parfum5 = new Parfum(null, "Agel","Thierry Mugler", 2000, "Romania" , "Femeie", "continut1", "descriere1",201.0f, 100, "apa de toaleta","https://www.parfimo.ro/data/cache/thumb_min500_max1000-min500_max1000-12/products/95831/1620023167/thierry-mugler-angel-apa-de-parfum-pentru-femei-reincarcabil-50-ml-365778.jpg", false,null);

			Parfum parfum6 = new Parfum(null, "Scandal By Night","Jean Paul Gaultier", 2000, "Romania" , "Femeie", "continut1", "descriere1",200.0f, 100, "apa de toaleta","https://img.vivantiscdn.net/photos/p/_orig/JG/jean-p-gaultier-scandal-edp_1447812720181112142010.gif", false,null);

			Parfum parfum7 = new Parfum(null, "Lady Million","Paco Rabanne", 2000, "Romania" , "Femeie", "continut1", "descriere1",199.0f, 100, "apa de toaleta","https://www.parfimo.ro/data/cache/thumb_min500_max750-min500_max750-12/products/96025/1568012842/paco-rabanne-lady-million-apa-de-parfum-pentru-femei-80-ml-219884.jpg", false,null);


			Parfum parfum8 = new Parfum(null, "Olympea","Paco Rabanne", 2000, "Romania" , "Femeie", "continut1", "descriere1",250.0f, 100, "apa de toaleta","https://www.parfimo.ro/data/cache/thumb_min500_max1000-min500_max1000-12/products/96497/1602074772/paco-rabanne-olympea-apa-de-parfum-pentru-femei-80-ml-332679.jpg", false,null);

			parfumRepository.save(parfum1);
			parfumRepository.save(parfum2);
			parfumRepository.save(parfum3);
			parfumRepository.save(parfum4);
			parfumRepository.save(parfum5);
			parfumRepository.save(parfum6);
			parfumRepository.save(parfum7);
			parfumRepository.save(parfum8);


			ProdusComanda produscom1 = new ProdusComanda(null,100.0f,1, parfum1);
			ProdusComanda produscom2 = new ProdusComanda(null,100.0f,1, parfum2);
			ProdusComanda produscom3 = new ProdusComanda(null,100.0f,1, parfum3);

			List<ProdusComanda> listaComanda1 = new ArrayList<>();

			listaComanda1.add(produscom1);
			listaComanda1.add(produscom2);

			List<Comanda> comenzi =  new ArrayList<>();
			produsComandaRepository.save(produscom1);
			produsComandaRepository.save(produscom2);
			Comanda comanda1=new Comanda(null,120.0f, LocalDate.now(),"Paul", "Vlasa", "Cluj", "Buna Ziua", "paul@yahoo.com", "0746568235",727200 );
			comandaRepository.save(comanda1);


			List<ProdusComanda> listaComanda2 = new ArrayList<>();
			listaComanda2.add(produscom3);
			produsComandaRepository.saveAll(listaComanda2);

			Comanda comanda2=new Comanda(null,100.0f, LocalDate.now(),"Denisa", "Naica", "Dezmir", "nu stiu", "denisa@yahoo.com", "0746568954",568552 );

			//
			comenzi.add(comanda1);
			comandaRepository.save(comanda2);


			//User user2 = new User(null, "Andreea2","123", "apirvu99@yahoo.ro", "012", RolUser.USER);
			//User user3 = new User(null, "Andreea2","123", "apirvu99@yahoo.ro", "012", RolUser.USER);
			//List<User> users = new ArrayList<>();

			User user2 = new User(null, "Paul","123", "ceva@yahoo.ro", 0123, RolUser.ADMIN,true,listaComanda2,null,false, false);
			BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
			String encodedPassword2 = encoder2.encode(user2.getPassword());
			System.out.println(encoder2.matches(user2.getPassword(), encodedPassword2));
			user2.setPassword(encodedPassword2);
			User user3 = new User(null, "Andreea99","123", "apirvu99@yahoo.ro", 0123,RolUser.USER,true,null, null, false, false);
			BCryptPasswordEncoder encoder3 = new BCryptPasswordEncoder();
			String encodedPassword3 = encoder3.encode(user3.getPassword());
			System.out.println(encoder3.matches(user3.getPassword(), encodedPassword3));
			user3.setPassword(encodedPassword3);

			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);

			ProdusComanda produscom4 = new ProdusComanda(null,100.0f,1, null);
			produsComandaRepository.save(produscom4);



			/*ParfumReviewAdditionDTO parfumReviewAdditionDTO = new ParfumReviewAdditionDTO();
			parfumReviewAdditionDTO.setParfumID(3l);
			parfumReviewAdditionDTO.setReviewID(1l);
			parfumService.updateReview(parfumReviewAdditionDTO);*/



			//users.add(user2);
			//users.add(user3);
			//userRepository.saveAll(users);
			//List<User> users2 = new ArrayList<>();
			//users2=userRepository.findAll();
			//userRepository.extractLastRol(userRepository.extractMaxID(users));
			//System.out.println(userRepository.extractLastRol(userRepository.extractMaxID(users2)));

			/*ProdusComandaAddParfumDTO produsComandaAddParfumDTO = new ProdusComandaAddParfumDTO();
			produsComandaAddParfumDTO.setParfumID(1L);
			produsComandaAddParfumDTO.setProdusID(4l);
			System.out.println(produsComandaAddParfumDTO.getParfumID());
			produscom4 = produsComandaService.updateParfum(produsComandaAddParfumDTO);
			System.out.println(produscom4);*/








		};
	}

}
