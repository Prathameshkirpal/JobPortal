package com.portal.jobapp.jobs.impl;

import com.portal.jobapp.jobs.Job;
import com.portal.jobapp.jobs.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImplementation implements JobService {
    private List<Job> jobs = new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }
}
