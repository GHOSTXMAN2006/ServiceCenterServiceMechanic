package com.example.serviceapplication.service;

import com.example.serviceapplication.data.Center;
import com.example.serviceapplication.data.CenterRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CenterServices {

    @Autowired
    private CenterRepository centerRepo;

    public List<Center> getAllCenters() {
        return centerRepo.findAll();
    }

    public Center createCenter(Center center){

        return centerRepo.save(center);
    }

    public Center updateCenter(Center center){
        return centerRepo.save(center);
    }

    public Center deleteCenterById(int id){
        Optional<Center> cen = centerRepo.findById(id);
        if (cen.isPresent()){
            centerRepo.deleteById(id);
            return cen.get();
        } else {
            return null;
        }
    }
}
