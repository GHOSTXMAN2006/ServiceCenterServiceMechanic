package com.example.serviceapplication.controller;

import com.example.serviceapplication.data.Center;
import com.example.serviceapplication.data.Mechanic;
import com.example.serviceapplication.service.MechanicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MechanicController {

    @Autowired
    private MechanicServices mechanicServices;

    @GetMapping(path = "/mechanics")
    public List<Mechanic> getAllMechanics(){

        return mechanicServices.getAllMechanics();

    }

    @GetMapping("/mechanics/{id}")
    public Mechanic getMechanicById(@PathVariable int id){

        return mechanicServices.getMechanicById(id);
    }

    @PostMapping(path = "/mechanics")
    public Mechanic createMechanic(@RequestBody Mechanic mechanic){

        return mechanicServices.createMechanic(mechanic);
    }

    @PutMapping(path = "/mechanics")
    public Mechanic updateMechanic(@RequestBody Mechanic mechanic){
        return mechanicServices.updateMechanic(mechanic);
    }

    @DeleteMapping("/mechanics/{id}")
    public void deleteMechanic(@PathVariable int id){
        mechanicServices.deleteMechanicById(id);
    }

    @GetMapping("/mechanics/available")
    public List<Mechanic> getAvailableMechanics() {
        return mechanicServices.getAvailableMechanics();
    }
}
