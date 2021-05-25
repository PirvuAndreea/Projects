package com.ps.Magazin.controller;

import com.ps.Magazin.dto.ParfumCosDto;
import com.ps.Magazin.dto.ParfumCosDtoDelete;
import com.ps.Magazin.dto.ParfumDto;
import com.ps.Magazin.dto.ParfumReviewAdditionDTO;
import com.ps.Magazin.model.Parfum;
import com.ps.Magazin.repository.ParfumRepository;
import com.ps.Magazin.service.ParfumService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/parfum")
@CrossOrigin
public class ParfumController {
    private final ParfumService parfumService;
    private final ParfumRepository parfumRepository;

    public ParfumController(ParfumService parfumService, ParfumRepository parfumRepository) {
        this.parfumService = parfumService;
        this.parfumRepository = parfumRepository;
    }

    @ApiOperation(value = "Return parfum by id")
    @GetMapping("/{id}")
    public ResponseEntity findParfumById(@ApiParam(value = "Requires an parfum id")@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(parfumService.findbyId(id));
    }

    @ApiOperation(value = "Returns a list of all parfum.")
    @GetMapping()
    public ResponseEntity findAllParfum(){
        return ResponseEntity.status(HttpStatus.OK).body(parfumService.findAll());
    }

    @ApiOperation(value = "Returns a list of all parfum from cart")
    @GetMapping("/inCos")
    public ResponseEntity findAllParfumInCos(){
        return ResponseEntity.status(HttpStatus.OK).body(parfumService.parfumTrueInCos());
    }

    @ApiOperation(value = "Add new parfum in list")
    @PostMapping("/save")
    public ResponseEntity saveNewParfum(@ApiParam(value = "Requires a new parfum")@RequestBody ParfumDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(parfumService.save(dto));
    }

    @ApiOperation(value = "Add new review at parfum")
    @PutMapping
    public ResponseEntity updateReviewsParfum(@ApiParam(value = "Requires a parfum id, author review and message review")@RequestBody ParfumReviewAdditionDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(parfumService.updateReview(dto));
    }

    @ApiOperation(value = "Update parfum when added in cart")
    @PutMapping("/addCart")
    public ResponseEntity updateParfumCos(@ApiParam(value = "Requires a parfum id and boolean value for cart")@RequestBody ParfumCosDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(parfumService.updateCos(dto));
    }

    @ApiOperation(value = "Delete parfum from cart")
    @PutMapping("/deleteCart")
    public ResponseEntity updateParfumCosDelete(@ApiParam(value = "Requires a parfum id")@RequestBody ParfumCosDtoDelete dto){
        return ResponseEntity.status(HttpStatus.OK).body(parfumService.updateCosDelete(dto));
    }
    @ApiOperation(value = "take perfumes out of the cart when user exit")
    @PutMapping("/exit")
    public ResponseEntity updateParfumCosFaslse(){
        return ResponseEntity.status(HttpStatus.OK).body(parfumService.updateCosFalse());
    }
    @ApiOperation(value = "Update parfum from list")
    @PutMapping("/update")
    public ResponseEntity updateParfum(@ApiParam(value = "Requires an existant parfum")@RequestBody Parfum dto){
        return ResponseEntity.status(HttpStatus.OK).body(parfumService.updateParfum(dto));
    }

    @ApiOperation(value = "Delete parfum by id from list.")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteParfumById(@ApiParam(value = "Requires an parfum id")@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(parfumService.deleteParfum(id));
    }

    @GetMapping("/export/{id}")
    public ResponseEntity exportOwnerCarDetails(@PathVariable Long id, @RequestParam String fileType) {
        return ResponseEntity.ok(parfumService.exportParfumDetails(id, fileType));

    }
}
