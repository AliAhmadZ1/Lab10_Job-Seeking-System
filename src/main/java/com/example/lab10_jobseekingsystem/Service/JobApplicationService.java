package com.example.lab10_jobseekingsystem.Service;

import com.example.lab10_jobseekingsystem.Model.JobApplication;
import com.example.lab10_jobseekingsystem.Repository.JobApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public List<JobApplication> getAllJobApplication(){
        return jobApplicationRepository.findAll();
    }

    public void applyForJob(JobApplication jobApplication){
        jobApplicationRepository.save(jobApplication);
    }

    public Boolean withdrawJobApplication(Integer id){
        JobApplication oldJobApplication = jobApplicationRepository.getById(id);
        if (oldJobApplication==null)
            return false;

        jobApplicationRepository.delete(oldJobApplication);
        return true;
    }
}
