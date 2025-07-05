package com.example.serviceapplication.controller;

import com.example.serviceapplication.data.Mechanic;
import com.example.serviceapplication.service.MechanicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend calls
@RestController
public class MechanicController {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private MechanicServices mechanicServices;

    @GetMapping(path = "/mechanics")
    public List<Mechanic> getAllMechanics() {
        return mechanicServices.getAllMechanics();
    }

    @GetMapping("/mechanics/{id}")
    public Mechanic getMechanicById(@PathVariable int id) {
        return mechanicServices.getMechanicById(id);
    }

    @PostMapping(path = "/mechanics")
    public Mechanic createMechanic(@RequestBody Mechanic mechanic) {
        return mechanicServices.createMechanic(mechanic);
    }

    @PutMapping(path = "/mechanics")
    public Mechanic updateMechanic(@RequestBody Mechanic mechanic) {
        return mechanicServices.updateMechanic(mechanic);
    }

    @DeleteMapping("/mechanics/{id}")
    public void deleteMechanic(@PathVariable int id) {
        mechanicServices.deleteMechanicById(id);
    }

    @GetMapping("/mechanics/available")
    public List<Mechanic> getAvailableMechanics() {
        return mechanicServices.getAvailableMechanics();
    }

    // Upload mechanic image and return URL
    @PostMapping("/mechanics/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile imageFile) {
        if (imageFile.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No file selected");
        }
        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            String filename = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
            Path filepath = Paths.get(UPLOAD_DIR, filename);
            Files.write(filepath, imageFile.getBytes());

            String fileUrl = "http://localhost:8081/service-app/" + UPLOAD_DIR + filename;
            return ResponseEntity.ok(fileUrl);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving file");
        }
    }

    // NEW: Search mechanics by query (name or skillset)
    @GetMapping("/mechanics/search")
    public List<Mechanic> searchMechanics(@RequestParam("query") String q) {
        return mechanicServices.searchMechanics(q);
    }

}
