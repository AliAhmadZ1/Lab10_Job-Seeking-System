package com.example.lab10_jobseekingsystem.Controller;

import com.example.lab10_jobseekingsystem.ApiResponse.ApiResponse;
import com.example.lab10_jobseekingsystem.Model.JobApplication;
import com.example.lab10_jobseekingsystem.Service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-application")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getAllJobApplication(){
        if (jobApplicationService.getAllJobApplication().isEmpty())
            return ResponseEntity.status(400).body(new ApiResponse("there are no applications"));
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplication());
    }

    @PostMapping("/apply")
    public ResponseEntity applyForJob(@RequestBody JobApplication jobApplication){
        jobApplicationService.applyForJob(jobApplication);
        return ResponseEntity.status(200).body(new ApiResponse("Job application is applied"));
    }

    @DeleteMapping("/withdraw/{id}")
    public ResponseEntity withdrawJobApplication(@PathVariable Integer id){
        jobApplicationService.withdrawJobApplication(id);
        return ResponseEntity.status(200).body(new ApiResponse("Job application is withdrawn"));
    }
}
