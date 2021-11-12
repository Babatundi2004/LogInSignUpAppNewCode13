package com.example.loginsignupapp;

enum RestCategory
{
    Oriental, Chinese, Sushi, Thai, Mexican, Fast
}

public class Restaurant {

    private String name;
    private String description;
    private String address;
    private String phone;
    private RestCategory category;
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public RestCategory getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCategory(RestCategory category) {
        this.category = category;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Restaurant(String name, String description, String address, String phone, RestCategory category, String photo) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.category = category;
        this.photo = photo;
    }

    public Restaurant(String name, String description, String address, RestCategory restCategory, String photo, String phone){
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", category=" + category +
                ", photo='" + photo + '\'' +
                '}';
    }
}

