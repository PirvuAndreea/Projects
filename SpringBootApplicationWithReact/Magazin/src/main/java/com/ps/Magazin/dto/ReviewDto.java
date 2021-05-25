package com.ps.Magazin.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private String autor;
    private String mesaj;
    private LocalDate data;
}
