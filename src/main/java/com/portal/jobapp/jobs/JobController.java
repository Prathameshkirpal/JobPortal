package com.portal.jobapp.jobs;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobservice;

    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        List<Job> joblist = jobservice.findAll();
        return ResponseEntity.ok(jobservice.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobservice.createJob(job);
        return new ResponseEntity<>("Job Added Successfully",HttpStatus.CREATED) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job =  jobservice.getJobById(id);
        if (job != null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean delete = jobservice.deleteJobById(id);
        if (delete) {
            return ResponseEntity.ok("Deleted Successfully");
        }
        return new ResponseEntity<>("The Job with the given ID not found",HttpStatus.NOT_FOUND);
    }

    //@PutMapping("/jobs/{id}")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updateJob) {
        boolean updateStatus = jobservice.updateJob(id,updateJob);
        if(updateStatus){
         return ResponseEntity.ok("Updated Successfully");
        }
        return new ResponseEntity<>("The id of the content to be updated is not found",HttpStatus.NOT_FOUND);


    }
}
