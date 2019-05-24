package com.galvanize.employeedb.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.employeedb.Controllers.JobController;
import com.galvanize.employeedb.Entities.Job;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(JobController.class)
public class JobControllerTest {

    @Autowired
    public MockMvc mvc;

    String url;

    Job job;



    @Before
    public void setup(){
        url = "http://localhost:8080/job/";

        job = new Job();
        job.setEmpID(1);
        job.setCustomer("someone");
        job.setStartDate(new Date(2019/11/11));
        job.setEndDate(new Date(2019/11/12));
    }
    @Test
    public void addJob() throws Exception{
        mvc.perform( MockMvcRequestBuilders
                .post(url+"add")
                .content(asJsonString(job))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void getById() throws Exception{
        mvc.perform( MockMvcRequestBuilders
                .get(url+"get/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.jobID").value(1));
    }


    @Test
    public void updateByID() throws Exception{
        mvc.perform( MockMvcRequestBuilders
                .put(url+"{/id}", 2)
                .content(asJsonString(job))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
