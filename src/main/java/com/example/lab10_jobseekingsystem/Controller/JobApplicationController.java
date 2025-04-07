package com.example.lab10_jobseekingsystem.Controller;

import com.example.lab10_jobseekingsystem.ApiResponse.ApiResponse;
import com.example.lab10_jobseekingsystem.Model.JobApplication;
import com.example.lab10_jobseekingsystem.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/job-application")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getAllJobApplication() {
        if (jobApplicationService.getAllJobApplication().isEmpty())
            return ResponseEntity.status(400).body(new ApiResponse("there are no applications"));
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplication());
    }

    @PostMapping("/apply")
    public ResponseEntity applyForJob(@RequestBody @Valid JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        Boolean isApplied = jobApplicationService.applyForJob(jobApplication);
        if (isApplied)
            return ResponseEntity.status(200).body(new ApiResponse("Job application is applied"));
        return ResponseEntity.status(400).body(new ApiResponse("not found or already applied"));
    }

    @DeleteMapping("/withdraw/{id}")
    public ResponseEntity withdrawJobApplication(@PathVariable Integer id) {
//        for (JobApplication ja: jobApplicationService.getAllJobApplication()){
//            if (ja.getId()==id){
//                jobApplicationService.withdrawJobApplication(id);
//                return ResponseEntity.status(200).body(new ApiResponse("Job application is withdrawn"));
//            }
//        }
        boolean isDeleted = jobApplicationService.withdrawJobApplication(id);
        if (isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("Job application is withdrawn"));
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }
}
