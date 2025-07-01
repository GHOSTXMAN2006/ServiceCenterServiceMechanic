package com.example.serviceapplication.service;

import com.example.serviceapplication.data.Center;
import com.example.serviceapplication.data.CenterRepository;
import com.example.serviceapplication.data.Mechanic;
import com.example.serviceapplication.data.MechanicRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicServices {

    @Autowired
    private MechanicRepository mechanicRepository;

    public List<Mechanic> getAllMechanics() {
        return mechanicRepository.findAll();
    }

    public Mechanic getMechanicById(int id){
        Optional<Mechanic> mec = mechanicRepository.findById(id);
        if (mec.isPresent()){

        }
        return mec.get();
    }

    public Mechanic createMechanic(Mechanic mechanic){

        return mechanicRepository.save(mechanic);
    }

    public Mechanic updateMechanic(Mechanic mechanic){
        return mechanicRepository.save(mechanic);
    }

    public Mechanic deleteMechanicById(int id){
        Optional<Mechanic> mec = mechanicRepository.findById(id);
        if (mec.isPresent()){
            mechanicRepository.deleteById(id);
            return mec.get();
        } else {
            return null;
        }
    }

    public List<Mechanic> getAvailableMechanics() {
        return mechanicRepository.findAvailableMechanics();
    }
}
