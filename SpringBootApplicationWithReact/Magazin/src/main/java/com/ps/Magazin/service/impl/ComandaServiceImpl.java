package com.ps.Magazin.service.impl;

import com.ps.Magazin.dto.ComandaDto;
import com.ps.Magazin.dto.ComandaSuccesDto;
import com.ps.Magazin.mapper.ComandaMapper;
import com.ps.Magazin.model.*;
import com.ps.Magazin.repository.ComandaRepository;
import com.ps.Magazin.repository.ProdusComandaRepository;
import com.ps.Magazin.repository.UserRepository;
import com.ps.Magazin.service.ComandaService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ComandaServiceImpl implements ComandaService {

    private final ComandaRepository comandaRepository;
    private final UserRepository userRepository;
    private final ProdusComandaRepository produsComandaRepository;
    private final JavaMailSender javaMailSender;

    public ComandaServiceImpl(ComandaRepository comandaRepository, UserRepository userRepository, ProdusComandaRepository produsComandaRepository, JavaMailSender javaMailSender) {
        this.comandaRepository = comandaRepository;
        this.userRepository = userRepository;
        this.produsComandaRepository = produsComandaRepository;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public Comanda findById(Long id) {
        return comandaRepository.findById(id).get();
    }

    @Override
    public void save(Comanda comanda) {
        comandaRepository.save(comanda);

    }

    @Override
    public void delete(Long id) {
        comandaRepository.deleteById(id);

    }

    @Override
    public List<Comanda> listAll() {
        return (List<Comanda>) comandaRepository.findAll();
    }

    @Override
    public List<Comanda> findComandaByEmail(String email) {
        return null;
    }




    @Override
    public Comanda findByAdresa(String adresa) {
        return comandaRepository.findByAdresa(adresa);
    }

    @Override
    public ComandaSuccesDto save(ComandaDto comandaDto) {
        //dto->model
        //repo.save(model)
        //mapare model -> dto
        //return dto
        Float pret_total=0f;
        Comanda comanda = ComandaMapper.mapDtoToModel(comandaDto);
        User user = userRepository.findByEmail(comandaDto.getEmail());
        System.out.println(user);
        List<ProdusComanda> produse = user.getProduse();
        String parf="";
        System.out.println(produse);
        for(ProdusComanda produs :produse)
        {
            pret_total += produs.getValoare();
            produs.getParfum().setCantitate(produs.getParfum().getCantitate()-produs.getCantitate());
            parf += "\n" + produs.getParfum().getNumeparfum() + " " + produs.getCantitate() + " " + produs.getValoare();
        }
        System.out.println(parf);
        System.out.println(pret_total);
        comanda.setPrettotal(pret_total);



        comandaRepository.save(comanda);



        ComandaMapper.mapModelToDto(comanda);
        ComandaSuccesDto comandaSuccesDto = new ComandaSuccesDto();
        comandaSuccesDto.setId(comanda.getId());
        comandaSuccesDto.setPrettotal(comanda.getPrettotal());


         SimpleMailMessage msg = new SimpleMailMessage();
         msg.setTo(comandaDto.getEmail());

         String codDeTrimis ="Comanda cu numarul " + comanda.getId() + " a fost plasata\n" + "Totalul comenzii: " + comanda.getPrettotal()
                 + "\n\nDetalii comanda: \n\n"
                 + "Nume: " + comanda.getNume() + "\n"
                 + "Prenume: " + comanda.getPrenume() + "\n"
                 + "Oras: " + comanda.getOras() + "\n"
                 + "Adresa: " + comanda.getAdresa() + "\n"
                 + "Numar telefon: " + comanda.getNrtelefon() + "\n"
                 ;
         String produse_comandate = "Produse comandate: " + parf;
         String msj="\n\n\n\nMultumim!";
         msg.setSubject("WebShop");



         msg.setText(codDeTrimis + produse_comandate+msj);

         javaMailSender.send(msg);

        user.getProduse().removeAll(produse);
        userRepository.save(user);

         for(ProdusComanda produs :produse)
        {
          produsComandaRepository.delete(produs);
        }




        return comandaSuccesDto;
    }




}
