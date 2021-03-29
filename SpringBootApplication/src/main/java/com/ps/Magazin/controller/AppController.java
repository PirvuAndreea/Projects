package com.ps.Magazin.controller;

import com.ps.Magazin.model.*;
import com.ps.Magazin.repository.ParfumRepository;
import com.ps.Magazin.repository.ProdusComandaRepository;
import com.ps.Magazin.repository.UserRepository;
import com.ps.Magazin.service.UserService;
import com.ps.Magazin.service.impl.ComandaServiceImpl;
import com.ps.Magazin.service.impl.ParfumServiceImpl;
import com.ps.Magazin.service.impl.ReviewServiceImpl;
import com.ps.Magazin.service.impl.UserServiceImpl;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;

@Controller
//@RestController
public class AppController {


  //  private final UserRepository userRepository;
  //  private final ParfumRepository parfumRepository;
    private final ParfumServiceImpl parfumService;

    private final UserServiceImpl userService;

    private final ComandaServiceImpl comandaService;

    private final ProdusComandaRepository produsComandaRepository;

    private final ReviewServiceImpl reviewService;


    public AppController(UserRepository userRepository, ParfumServiceImpl parfumService, UserServiceImpl userService, ComandaServiceImpl comandaService,ProdusComandaRepository produsComandaRepository, ReviewServiceImpl reviewService) {
      //  this.userRepository = userRepository;
      //  this.parfumRepository=parfumRepository;
        this.parfumService=parfumService;
        this.userService=userService;
        this.comandaService=comandaService;
        this.produsComandaRepository=produsComandaRepository;
        this.reviewService=reviewService;


    }


    public String getEmail() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof CustomUserDetails) {
            username = ((CustomUserDetails) principal).getUsername();
           // System.out.println(username);
        } else {
            username = principal.toString();
         //   System.out.println(username);
        }
        return username;
    }


    public static String generateRandomPassword(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                +"lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }


    @GetMapping("")
    public String viewHomePage(){

        return "index";
    }
    @GetMapping("/register")
        public String showSignUpForm(Model model){
            model.addAttribute("user", new User());

            return "signup_form";
        }
    @PostMapping("/process_register")
    public String processRegistration(User user){

        if(userService.findByUsername(user.getUsername())!=null) {
            return "UsernameExist";
        }
        else if(userService.findByEmail(user.getEmail())!=null)
        {
            return "EmailExist";
        }
        else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            user.setCodactivare(generateRandomPassword(5));
            user.setRol(RolUser.USER);
            userService.save(user);
            return "register_succes";
        }
    }
    @GetMapping("/list_users")
    public String viewUsersList(Model model) {
        List <User> listUsers = (List<User>) userService.listAll();
        model.addAttribute("listUsers",listUsers );
        return "users";

    }

    @GetMapping("/user_menu")
    public String viewUserMenu(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof CustomUserDetails) {
            username = ((CustomUserDetails)principal).getUsername();
            //System.out.println(username);
        }
        else {
            username = principal.toString();
           // System.out.println(username);
        }

        if(userService.extractLastRol1(username)=="USER") {
            return "UserMenu";
        }
        else {

            return "AdminMenu";
        }

    }

    @RequestMapping("/product_manager")
    public String productManager(Model model, @Param("keyword")String keyword) {
        List<Parfum> listParfum = parfumService.listAll(keyword);
       // System.out.println(listParfum);
        model.addAttribute("listParfum",listParfum);
        model.addAttribute("keyword", keyword);
        return "parfumTable";
    }

    @RequestMapping("/newParfum")
    public String showNewParfumForm(Model model) {
        Parfum parfum= new Parfum();
        model.addAttribute("parfum", parfum);
        return "new_parfum";
    }

    @RequestMapping(value = "/saveParfum", method=RequestMethod.POST)
    public String saveParfum(@ModelAttribute("parfum")Parfum parfum){
        parfumService.save(parfum);
        return "redirect:/product_manager";

    }

    @RequestMapping("/editParfum/{id}")
    public ModelAndView showEditParfumForm(@PathVariable(name = "id")Long id) {
        ModelAndView mav= new ModelAndView("edit_parfum");
        Parfum parfum = parfumService.findbyId(id);
        mav.addObject("parfum",parfum);

        return mav;
    }



    @RequestMapping("/deleteParfum/{id}")
    public String deleteParfum(@PathVariable(name = "id")Long id){
        Parfum parfum = parfumService.findbyId(id);
        Long id1=produsComandaRepository.findParfumisProdusComanda(parfum);
        System.out.println(parfum);
        System.out.println(id1);
        System.out.println(id);
      //  System.out.println(produsComandaRepository.findById(id1).get());
        if(produsComandaRepository.findById(id1).get() != null)
        {
            produsComandaRepository.delete(produsComandaRepository.findById(id1).get());
        }

        parfumService.delete(id);


        return "redirect:/product_manager";
    }



    @GetMapping("/list_parfumuri")
    public String viewProductList(Model model, @Param("keyword")String keyword) {
        List<Parfum> listParfum = parfumService.listAll(keyword);
        // System.out.println(listParfum);
        model.addAttribute("listParfum",listParfum);
        model.addAttribute("keyword", keyword);
        return "parfumuri";

    }

    @RequestMapping("/newUser")
    public String showNewUserForm(Model model) {
        User user= new User();
        model.addAttribute("user", user);
        return "new_user";
    }
    @RequestMapping(value = "/saveUser", method=RequestMethod.POST)
    public String saveUser(@ModelAttribute("user")User user){
        user.setRol(RolUser.ADMIN);
        user.setCodactivare(generateRandomPassword(5));
        userService.save(user);
        return "redirect:/list_users";

    }

    @RequestMapping("/editUser/{id}")
    public ModelAndView showEditUserForm(@PathVariable(name = "id")Long id) {
        ModelAndView mav= new ModelAndView("edit_user");
        User user = userService.findbyId(id);
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id")Long id){
        userService.delete(id);
        return "redirect:/list_users";
    }


    @RequestMapping("/lista_comenzi")
    public String viewListaComenzi(Model model) {
        List<Comanda> listaComanda = comandaService.listAll();
        model.addAttribute("listaComanda",listaComanda);
        return "comandaTable";
    }

    @RequestMapping("/newComanda")
    public String showNewComandaForm(Model model) {
        Parfum parfum = new Parfum();
        ProdusComanda produsComanda = new ProdusComanda();
        Comanda comanda= new Comanda();


        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("comanda", comanda);
        attributes.put("parfum", parfum);
        attributes.put("produsComanda", produsComanda);
        model.addAllAttributes(attributes);


        return "new_comanda";
    }


    @RequestMapping(value = "/saveComanda", method=RequestMethod.POST)
    public String saveComanda(@ModelAttribute("comanda")Comanda comanda,@ModelAttribute("parfum")Parfum parfum, @ModelAttribute("produsComanda")ProdusComanda produsComanda){
       // List<ProdusComanda> listaComanda1 = new ArrayList<>();

        ///System.out.println(produsComandaRepository.findById(parfum.getId()));

        //produsComanda.setValoare();
        // System.out.println(produsComandaRepository.findParfumisProdusComanda(parfum));
        parfumService.save(parfum);
        produsComanda.setParfum(parfum);
        List<ProdusComanda> listaComanda1 = new ArrayList<>();
        listaComanda1.add(produsComanda);
        produsComandaRepository.saveAll(listaComanda1);

        produsComanda.setValoare(parfumService.findbyNumeParfum(parfum.getNumeparfum()).getPret() * produsComanda.getCantitate());
       // listaComanda1.add(produsComanda);
       // comanda.setProduse(listaComanda1);
        comanda.setProduse(listaComanda1);
        comanda.setPrettotal(comanda.getProduse().size()* produsComanda.getValoare());
       /*// System.out.println(parfumService.findbyNumeParfum(parfum.getNumeparfum()).getCantitate() - produsComanda.getCantitate());

        *//*if(parfumService.findbyNumeParfum(parfum.getNumeparfum()).getCantitate() < produsComanda.getCantitate())
        {
            return "stocException";
        }*//*
        parfumService.findbyNumeParfum(parfum.getNumeparfum()).setCantitate(parfumService.findbyNumeParfum(parfum.getNumeparfum()).getCantitate()-produsComanda.getCantitate());*/
        parfumService.findbyNumeParfum(parfum.getNumeparfum()).setCantitate(parfumService.findbyNumeParfum(parfum.getNumeparfum()).getCantitate()-produsComanda.getCantitate());
        parfumService.save(parfum);
        //produsComandaRepository.saveAll(listaComanda1);

        produsComandaRepository.save(produsComanda);
        comandaService.save(comanda);

      //  System.out.println(comanda);


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof CustomUserDetails) {
            username = ((CustomUserDetails)principal).getUsername();
            //System.out.println(username);
        }
        else {
            username = principal.toString();
           // System.out.println(username);
        }

        if(userService.extractLastRol1(username)=="USER") {
            return "redirect:/user_menu";
        }
        else {

            return "redirect:/lista_comenzi";
        }
    }


    @RequestMapping(value = "/saveComanda1", method=RequestMethod.POST)
    public String saveComanda1(@ModelAttribute("comanda")Comanda comanda,@ModelAttribute("parfum")Parfum parfum, @ModelAttribute("produsComanda")ProdusComanda produsComanda){
        // List<ProdusComanda> listaComanda1 = new ArrayList<>();

        ///System.out.println(produsComandaRepository.findById(parfum.getId()));
        // produsComanda.setParfum(parfum);
        //produsComanda.setValoare();
        // System.out.println(produsComandaRepository.findParfumisProdusComanda(parfum));
        // parfumService.save(parfum);

        // produsComanda.setValoare(parfumService.findbyNumeParfum(parfum.getNumeparfum()).getPret() * produsComanda.getCantitate());
        // listaComanda1.add(produsComanda);
        // comanda.setProduse(listaComanda1);
        // comanda.setPrettotal(comanda.getProduse().size()* produsComanda.getValoare());
        /*// System.out.println(parfumService.findbyNumeParfum(parfum.getNumeparfum()).getCantitate() - produsComanda.getCantitate());

         *//*if(parfumService.findbyNumeParfum(parfum.getNumeparfum()).getCantitate() < produsComanda.getCantitate())
        {
            return "stocException";
        }*//*
        parfumService.findbyNumeParfum(parfum.getNumeparfum()).setCantitate(parfumService.findbyNumeParfum(parfum.getNumeparfum()).getCantitate()-produsComanda.getCantitate());*/
        //parfumService.findbyNumeParfum(parfum.getNumeparfum()).setCantitate(parfumService.findbyNumeParfum(parfum.getNumeparfum()).getCantitate()-produsComanda.getCantitate());
        ///parfumService.save(parfum);
        //produsComandaRepository.saveAll(listaComanda1);
        //produsComandaRepository.save(produsComanda);
        comandaService.save(comanda);

        //  System.out.println(comanda);


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof CustomUserDetails) {
            username = ((CustomUserDetails)principal).getUsername();
            //System.out.println(username);
        }
        else {
            username = principal.toString();
            // System.out.println(username);
        }

        if(userService.extractLastRol1(username)=="USER") {
            return "redirect:/user_menu";
        }
        else {

            return "redirect:/lista_comenzi";
        }
    }






    @RequestMapping("/editComanda/{id}")
    public ModelAndView showEditComandaForm(@PathVariable(name = "id")Long id) {
        ModelAndView mav= new ModelAndView("edit_comanda");
        Comanda comanda = comandaService.findById(id);
        mav.addObject("comanda",comanda);
        return mav;
    }

    @RequestMapping("/deleteComanda/{id}")
    public String deleteComanda(@PathVariable(name = "id")Long id){
        comandaService.delete(id);
        return "redirect:/lista_comenzi";
    }

    @RequestMapping("/new_review")
    public String showNewReviewForm(Model model) {
        Parfum parfum = new Parfum();

       Review review = new Review();
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("parfum", parfum);
        attributes.put("review", review);
        model.addAllAttributes(attributes);

        return "new_review";
    }



    @RequestMapping(value = "/saveReview", method=RequestMethod.POST)
    public String saveReview(@ModelAttribute("review")Review review,@ModelAttribute("parfum")Parfum parfum) {
        Parfum parfum1 = parfumService.findbyNumeParfum(parfum.getNumeparfum());
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(review);
        reviewService.save(review);
        System.out.println(reviewService.findByAutor(userService.findUsername(getEmail())));
        parfum1.addReview(review);
        parfumService.save(parfum1);
        return "redirect:/user_menu";
    }

    @RequestMapping("/lista_review")
    public String showListaReview(Model model){
        List <Review> reviewList = (List<Review>) reviewService.findByAutor(userService.findUsername(getEmail()));
        model.addAttribute("reviewList",reviewList );
        return "lista_review";
    }

    @RequestMapping("/editReview/{id}")
    public ModelAndView showEditReviewForm(@PathVariable(name = "id")Long id) {
        ModelAndView mav= new ModelAndView("edit_review");
        Review review = reviewService.findById(id);
        mav.addObject("review",review);
        return mav;
    }

    @RequestMapping(value = "/save_review", method=RequestMethod.POST)
    public String saveReviewEditat(@ModelAttribute("review")Review review) {
        reviewService.save(review);
        return "redirect:/lista_review";
    }

    @RequestMapping("/deleteReview/{id}")
    public String deleteReview(@PathVariable(name = "id")Long id){
        reviewService.delete(id);
        return "redirect:/lista_review";
    }
}
