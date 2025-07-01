package com.example.serviceapplication.service;

import com.example.serviceapplication.data.Clean;
import com.example.serviceapplication.data.CleanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleanServices {

    @Autowired
    private CleanRepository cleanRepository;

    public List<Clean> getAllVehicleServices() {
        return cleanRepository.findAll();
    }

    public Clean createVehicleService(Clean clean){

        return cleanRepository.save(clean);
    }

    public Clean updateVehicleService(Clean vehicleservice){
        return cleanRepository.save(vehicleservice);
    }

    public Clean deleteVehicleServiceById(int id){
        Optional<Clean> vs = cleanRepository.findById(id);
        if (vs.isPresent()){
            cleanRepository.deleteById(id);
            return vs.get();
        } else {
            return null;
        }
    }
}
