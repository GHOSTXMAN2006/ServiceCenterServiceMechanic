package com.example.serviceapplication.data;

import jakarta.persistence.*;

@Entity
@Table(name = "mechanics")
public class Mechanic {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "skillset")
    private String skillset;

    @Column(name = "availability")
    private int availability;

    @Column(name = "center_id")
    private int center_id;

    @Column(name = "image_url")  // New field for image path
    private String image_url;

    public Mechanic() {
    }

    public Mechanic(int id, String name, String skillset, int availability, int center_id, String image_url) {
        this.id = id;
        this.name = name;
        this.skillset = skillset;
        this.availability = availability;
        this.center_id = center_id;
        this.image_url = image_url;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkillset() {
        return skillset;
    }

    public void setSkillset(String skillset) {
        this.skillset = skillset;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
