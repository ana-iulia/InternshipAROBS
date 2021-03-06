package com.internshipArobs.servlet.domain;

public class OrderMenuItem extends Entity<Long> {
    private String name;
    private String description;
    private Float price;

    public OrderMenuItem(String name, String description, Float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public OrderMenuItem() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
