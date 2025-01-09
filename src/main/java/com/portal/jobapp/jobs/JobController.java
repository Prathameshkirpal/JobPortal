package com.portal.jobapp.jobs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private JobService jobservice;

    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobservice.findAll();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        jobservice.createJob(job);
        return "Job Added Successfully";
    }
}
