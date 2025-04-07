package com.example.lab10_jobseekingsystem.Service;

import com.example.lab10_jobseekingsystem.Model.JobPost;
import com.example.lab10_jobseekingsystem.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public List<JobPost> getJobPosts(){
        return jobPostRepository.findAll();
    }

    public void addJob(JobPost jobPost){
        jobPost.setPosting_date(LocalDate.now());
        jobPostRepository.save(jobPost);
    }

    public Boolean updateJob(Integer id, JobPost jobPost){
        JobPost oldJobPost = jobPostRepository.getById(id);

        if (oldJobPost ==null)
            return false;

        oldJobPost.setTitle(jobPost.getTitle());
        oldJobPost.setDescription(jobPost.getDescription());
        oldJobPost.setLocation(jobPost.getLocation());
        oldJobPost.setSalary(jobPost.getSalary());
        jobPostRepository.save(oldJobPost);
        return true;
    }

    public Boolean deleteJob(Integer id){
        JobPost jobPost = jobPostRepository.getById(id);
        if (jobPost==null)
            return false;
        jobPostRepository.delete(jobPost);
        return true;
    }
}
