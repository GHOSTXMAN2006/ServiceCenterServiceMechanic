package com.example.serviceapplication.data;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class Clean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String desc;

    private String price; // 💬 Changed from BigDecimal to String

    @Column(name = "image_url")
    private String imageUrl; // 🌟 Image path

    public Clean() {}

    public Clean(int id, String name, String desc, String price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    public String getPrice() { return price; } // 💬 Now String
    public void setPrice(String price) { this.price = price; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
