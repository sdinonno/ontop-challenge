package models;

import io.cucumber.java.eo.Do;

import java.math.BigDecimal;

public class Product {

    private String title;
    private Double price;
    private Double rating;
    private String descriptionTitle;
    private String description;
    private String url;

    public Product(String title, Double price, Double rating, String descriptionTitle, String description, String url){
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.descriptionTitle = descriptionTitle;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescriptionTitle() {
        return descriptionTitle;
    }

    public void setDescriptionTitle(String descriptionTitle) {
        this.descriptionTitle = descriptionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
