package com.example.serviceapplication.controller;

import com.example.serviceapplication.data.Clean;
import com.example.serviceapplication.service.CleanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CleanController {


    @Autowired
    private CleanServices vehicleserviceServices;

    @GetMapping(path = "/vehicleservices")
    public List<Clean> getAllVehicleServices(){

        return vehicleserviceServices.getAllVehicleServices();

    }

    @PostMapping(path = "/vehicleservices")
    public Clean createVehicleService(@RequestBody Clean vehicleservice) {

        return vehicleserviceServices.createVehicleService(vehicleservice);
    }


    @PutMapping(path = "/vehicleservices")
    public Clean updateVehicleService(@RequestBody Clean vehicleservice) {
        return vehicleserviceServices.updateVehicleService(vehicleservice);
    }


    @DeleteMapping("/vehicleservices/{id}")
    public void deleteVehicleService(@PathVariable int id){
        vehicleserviceServices.deleteVehicleServiceById(id);
    }
}
