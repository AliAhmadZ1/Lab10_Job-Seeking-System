package com.example.lab10_jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobApplication {

    //▪ id:
    //- Must be Generated.
    //▪ userId:
    //- Cannot be null.
    // ▪ jobPostId:
    //- Cannot be null.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
//    @Column(columnDefinition = "int not null, foreign key (user_id) references user(id)")
    private Integer user_id;
    @NotNull
//    @Column(columnDefinition = "int not null, foreign key (job_post_id) references job_post(id)")
    private Integer job_post_id;
}
