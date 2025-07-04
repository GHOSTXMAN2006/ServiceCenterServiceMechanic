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

    public Clean createVehicleService(Clean clean) {
        if (clean.getImageUrl() == null || clean.getImageUrl().isEmpty()) {
            clean.setImageUrl("/uploads/NoImageAvailable.jpg");  // default image if none provided
        }
        return cleanRepository.save(clean);
    }

    public Clean updateVehicleService(Clean cleanService) {
        if (cleanService.getImageUrl() == null || cleanService.getImageUrl().isEmpty()) {
            cleanService.setImageUrl("/uploads/NoImageAvailable.jpg");  // default image fallback
        }
        return cleanRepository.save(cleanService);
    }

    public Clean deleteVehicleServiceById(int id) {
        Optional<Clean> vs = cleanRepository.findById(id);
        if (vs.isPresent()) {
            cleanRepository.deleteById(id);
            return vs.get();
        } else {
            return null;
        }
    }

    public List<Clean> searchServices(String keyword) {
        return cleanRepository.search(keyword);
    }

}
