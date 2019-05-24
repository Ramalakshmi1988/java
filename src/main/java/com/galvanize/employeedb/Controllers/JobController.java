package com.galvanize.employeedb.Controllers;


import com.galvanize.employeedb.Entities.Job;
import com.galvanize.employeedb.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping(value = "/")
    public String getAppName(){
        return "Job App";
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Job> addJob(@RequestBody Job job){
        return new ResponseEntity<>(jobService.addJob(job), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Job> getById(@PathVariable long id){
        return new ResponseEntity<>(jobService.getById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/put/{id}")
    public ResponseEntity<Job> updateByID(@RequestBody Job job){
        return new ResponseEntity<>(jobService.addJob(job), HttpStatus.OK);
    }

}