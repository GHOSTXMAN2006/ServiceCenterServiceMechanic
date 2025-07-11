package com.example.serviceapplication.controller;

import com.example.serviceapplication.data.Clean;
import com.example.serviceapplication.service.CleanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CleanController {

    @Autowired
    private CleanServices cleanServices;

    //  Get all services
    @GetMapping("/vehicleservices")
    public List<Clean> getAllVehicleServices() {
        return cleanServices.getAllVehicleServices();
    }

    //  Create service
    @PostMapping("/vehicleservices")
    public Clean createVehicleService(@RequestBody Clean service) {
        return cleanServices.createVehicleService(service);
    }

    // Update service
    @PutMapping("/vehicleservices")
    public Clean updateVehicleService(@RequestBody Clean service) {
        return cleanServices.updateVehicleService(service);
    }

    //  Delete service
    @DeleteMapping("/vehicleservices/{id}")
    public void deleteVehicleService(@PathVariable int id) {
        cleanServices.deleteVehicleServiceById(id);
    }

    //  Upload image
    @PostMapping("/vehicleservices/upload")
    public String uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String folder = "uploads/";
        File dir = new File(folder);
        if (!dir.exists()) dir.mkdirs();

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        file.transferTo(new File(folder + fileName));
        return "/uploads/" + fileName;
    }

    //  Search services by keyword
    @GetMapping("/vehicleservices/search")
    public List<Clean> searchServices(@RequestParam String keyword) {
        return cleanServices.searchServices(keyword);
    }

}
