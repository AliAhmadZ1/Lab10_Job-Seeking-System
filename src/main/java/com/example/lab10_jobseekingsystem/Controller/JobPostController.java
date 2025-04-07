package com.example.lab10_jobseekingsystem.Controller;

import com.example.lab10_jobseekingsystem.ApiResponse.ApiResponse;
import com.example.lab10_jobseekingsystem.Model.JobPost;
import com.example.lab10_jobseekingsystem.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-post")
@RequiredArgsConstructor
public class JobPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getAllJobPosts(){
        if (jobPostService.getJobPosts().isEmpty())
            return ResponseEntity.status(400).body(new ApiResponse("there are no jobs"));
        return ResponseEntity.status(200).body(jobPostService.getJobPosts());
    }

    @PostMapping("/add")
    public ResponseEntity addJob(@RequestBody@Valid JobPost jobPost, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        jobPostService.addJob(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Job is posted"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJob(@PathVariable Integer id, @RequestBody@Valid JobPost jobPost, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        boolean isUpdated = jobPostService.updateJob(id, jobPost);
        if (isUpdated)
            return ResponseEntity.status(200).body(new ApiResponse("Job is updated"));
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJob(@PathVariable Integer id){
        boolean isDeleted = jobPostService.deleteJob(id);
        if (isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("Job is deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("Not Found"));
    }

}
