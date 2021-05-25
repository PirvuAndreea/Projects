package com.ps.Magazin.controller;

import com.ps.Magazin.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@CrossOrigin
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @ApiOperation(value = "Returns review by autor")
    @GetMapping("/{autor}")
    public ResponseEntity findReviewByAutor(@ApiParam(value = "Requires an autor")@PathVariable String autor){
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.findFirstByAutor(autor));
    }
}
