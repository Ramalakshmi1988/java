package com.galvanize.employeedb.Services;

import com.galvanize.employeedb.Entities.Job;
import com.galvanize.employeedb.Repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;


    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    public Job getById(long id) {
        return jobRepository.findById(id).orElse(null);
    }
}