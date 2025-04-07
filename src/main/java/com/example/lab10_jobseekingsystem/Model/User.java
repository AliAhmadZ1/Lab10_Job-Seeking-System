package com.example.lab10_jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Checks;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Check(constraints = "length(name)>=4")
//@Check(constraints = "name like '[A-Z]+'")
@Check(constraints = "email like '%_@__%.__%'")
@Check(constraints = "age >= 21")
@Check(constraints = "role = 'employer' or role = 'job_seeker'")
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
//    @Column(columnDefinition = "varchar(20) check (length(name)>=4)not null")
    private String name;
    @Email
    private String email;
    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null")
    private String password;
    @NotNull
    @Min(21)
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty
    @Pattern(regexp = "^(job_seeker|employer)$")
    @Column(columnDefinition = "varchar(10) not null")
    private String role;


}
