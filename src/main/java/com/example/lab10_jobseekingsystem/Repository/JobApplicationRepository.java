package com.example.lab10_jobseekingsystem.Repository;

import com.example.lab10_jobseekingsystem.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication,Integer> {

}
