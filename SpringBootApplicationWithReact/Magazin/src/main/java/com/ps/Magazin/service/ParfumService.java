package com.ps.Magazin.service;

import com.ps.Magazin.dto.ParfumCosDto;
import com.ps.Magazin.dto.ParfumCosDtoDelete;
import com.ps.Magazin.dto.ParfumDto;
import com.ps.Magazin.dto.ParfumReviewAdditionDTO;
import com.ps.Magazin.model.Parfum;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public interface ParfumService  {
    Parfum findbyId(Long id);
    Parfum updateParfum(Parfum dto);
    void delete(Long id);
    boolean delete(Parfum parfum);
    Parfum findbyNumeParfum(String numeparfum);
    Parfum findbyProducator(String producator);
    List<Parfum> findAll();
    List<Parfum> filter(List<String> parfum, List<String> gen, List<Integer> pret);
    List<Parfum> findByPerfumOrderByPriceDesc(String parfum);
    List<Parfum> findByPerfumGenOrderByPretDesc(String genparfum);
    Parfum savePerfum(Parfum parfum, MultipartFile file);
    ParfumDto save(ParfumDto parfumDto);
    Parfum updateReview(ParfumReviewAdditionDTO dto);
    Parfum updateCos(ParfumCosDto dto);
    List<Parfum> updateCosFalse();
    List<Parfum> parfumTrueInCos();
    Parfum updateCosDelete(ParfumCosDtoDelete dto);
    Parfum deleteParfum(Long id);
    String exportParfumDetails(Long id, String fileType);


}
