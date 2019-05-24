package com.galvanize.employeedb.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.*;

//@Data
@Entity
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
//@NoArgsConstructor(force = true)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empID;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date hireDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "empID")
    private List<Job> jobList = new ArrayList<>();


    public Employee(Long empID, String name, String address, String city, String state, String zip, Date hireDate) {
        this.empID = empID;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.hireDate = hireDate;
    }

    public Employee() {
    }

    public Long getEmpID() {
        return empID;
    }

    public void setEmpID(Long empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

//    public List<Job> getJobList() {
//        return jobList;
//    }
//
//    public void setJobList(List<Job> jobList) {
//        this.jobList = jobList;
//    }
}
