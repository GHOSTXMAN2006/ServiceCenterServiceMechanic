package com.example.serviceapplication.controller;

import com.example.serviceapplication.data.Center;
import com.example.serviceapplication.service.CenterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CenterController {

    @Autowired
    private CenterServices centerServices;

    @GetMapping(path = "/centers")
    public List<Center> getAllCenters(){

        return centerServices.getAllCenters();

    }

    @PostMapping(path = "/centers")
    public Center createCenter(@RequestBody Center center){

        return centerServices.createCenter(center);
    }

    @PutMapping (path = "/centers")
    public Center updateCenter(@RequestBody Center center){
        return centerServices.updateCenter(center);
    }

    @DeleteMapping("/centers/{id}")
    public void deleteCenter(@PathVariable int id){
        centerServices.deleteCenterById(id);
    }
}
