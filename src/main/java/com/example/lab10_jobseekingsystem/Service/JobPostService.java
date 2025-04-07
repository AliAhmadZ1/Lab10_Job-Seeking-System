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
        for (JobPost j: getJobPosts()) {
//            JobPost oldJobPost = jobPostRepository.getById(id);
//
//            if (oldJobPost == null)
//                return false;
            if (j.getId()==id) {
                j.setTitle(jobPost.getTitle());
                j.setDescription(jobPost.getDescription());
                j.setLocation(jobPost.getLocation());
                j.setSalary(jobPost.getSalary());
                jobPostRepository.save(j);
                return true;
            }
        }
        return false;
    }

    public Boolean deleteJob(Integer id){
        for (JobPost j:getJobPosts()) {
//            JobPost jobPost = jobPostRepository.getById(id);
//            if (jobPost == null)
//                return false;
            if (j.getId()==id) {
                jobPostRepository.delete(j);
                return true;
            }
        }
        return false;
    }
}
