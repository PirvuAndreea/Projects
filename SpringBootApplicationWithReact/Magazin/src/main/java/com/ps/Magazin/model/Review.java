package com.ps.Magazin.model;

import com.ps.Magazin.utils.ReviewEventListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Entity
@AllArgsConstructor
@Data
@EntityListeners(ReviewEventListener.class)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "autor cannot be empty")
    private String autor;
    @NotBlank(message = "mesaj cannot be empty")
    private String mesaj;
    private LocalDate data;

    public Review(){
        this.data=LocalDate.now();
    }

}
