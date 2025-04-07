package com.example.lab10_jobseekingsystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    //▪ id:
    //- Must be Generated.
    //▪ name:
    //- Cannot be null. //- Length must be more than 4 characters. //- Must contain only characters (no numbers).
    //▪ email:
    //- Must be a valid email format. //- Must be unique.
    //▪ password:
    //- Cannot be null.
    // ▪ age:
    //- Cannot be null. //- Must be a number. //- Must be more than 21.
    //▪ role:
    //- Cannot be null. //- Must be either "JOB_SEEKER" or "EMPLOYER" only

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 4)
    @Pattern(regexp = "^([A-Z]|[a-z]|\\s)+$")
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String password;
    @NotNull
    @Min(21)
    private Integer age;
    @NotEmpty
    @Pattern(regexp = "^(job_seeker|employer)$")
    private String role;


}
