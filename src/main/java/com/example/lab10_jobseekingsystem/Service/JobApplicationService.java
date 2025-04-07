package com.example.lab10_jobseekingsystem.Service;

import com.example.lab10_jobseekingsystem.Model.JobApplication;
import com.example.lab10_jobseekingsystem.Model.JobPost;
import com.example.lab10_jobseekingsystem.Model.User;
import com.example.lab10_jobseekingsystem.Repository.JobApplicationRepository;
import com.example.lab10_jobseekingsystem.Repository.JobPostRepository;
import com.example.lab10_jobseekingsystem.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;

    public List<JobApplication> getAllJobApplication() {
        return jobApplicationRepository.findAll();
    }

    public Boolean applyForJob(JobApplication jobApplication) {
        for (User u : userRepository.findAll()) {
            if (u.getId() == jobApplication.getUser_id()) {
                for (JobPost j : jobPostRepository.findAll()) {
                    if (j.getId() == jobApplication.getJob_post_id()) {
                        for (JobApplication ja : jobApplicationRepository.findAll()) {
                            if (ja.getUser_id() == u.getId() && ja.getJob_post_id() == j.getId())
                                return false;
                        }
                        jobApplicationRepository.save(jobApplication);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Boolean withdrawJobApplication(Integer id) {
        for (JobApplication ja : jobApplicationRepository.findAll()) {
            if (ja.getId() == id) {
//                JobApplication oldJobApplication = jobApplicationRepository.getById(id);
                jobApplicationRepository.delete(ja);
                return true;
            }
        }
        return false;
    }
}
