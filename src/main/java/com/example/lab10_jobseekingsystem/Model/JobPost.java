package com.example.lab10_jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Check(constraints = "salary>=0")
@Check(constraints = "length(title)>=4")
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 4)
//    @Column(columnDefinition = "varchar(20) check(length(title)>=4) not null") //varchar [ ( n | max ) ]
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String location;
    @NotNull
    @PositiveOrZero
//    @Column(columnDefinition = "double check(salary>=0) not null")
    private Double salary;
    private LocalDate posting_date;

}
