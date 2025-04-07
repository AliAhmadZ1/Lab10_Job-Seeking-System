package com.example.lab10_jobseekingsystem.Repository;

import com.example.lab10_jobseekingsystem.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost,Integer> {
}
