package com.example;

import javax.persistence.*;

@Entity
@Table(name = "meals")
public class meals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mealid;

    @Column(name="carbs")
    private long carbs;

    @Column(name="cooktime")
    private long cookTime;

    @Column(name="description")
    private String description;

    @Column(name="fat")
    private long fat;

    @Column(name="fibre")
    private long fibre;

    @Column(name="image_url")
    private String image_url;

    @Column(name="ingredients")
    private String ingredients;

    @Column(name="kcal")
    private long kcal;

    @Column(name="keywords")
    private String keywords;

    @Column(name="method")
    private String method;

    @Column(name="preptime")
    private long prepTime;

    @Column(name="protein")
    private long protein;

    @Column(name="rating")
    private double rating;

    @Column(name="salt")
    private long salt;

    @Column(name="saturates")
    private long saturates;

    @Column(name="sugars")
    private long sugars;

    @Column(name="title")
    private String title;

    public meals(long mealid, long carbs, long cookTime, String description, long fat, long fibre, String image_url, String ingredients, long kcal, String keywords, String method, long prepTime, long protein, double rating, long salt, long saturates, long sugars, String title) {
        this.mealid = mealid;
        this.carbs = carbs;
        this.cookTime = cookTime;
        this.description = description;
        this.fat = fat;
        this.fibre = fibre;
        this.image_url = image_url;
        this.ingredients = ingredients;
        this.kcal = kcal;
        this.keywords = keywords;
        this.method = method;
        this.prepTime = prepTime;
        this.protein = protein;
        this.rating = rating;
        this.salt = salt;
        this.saturates = saturates;
        this.sugars = sugars;
        this.title = title;
    }

    public long getMealid() {
        return mealid;
    }

    public void setMealid(long mealid) {
        this.mealid = mealid;
    }

    public long getCarbs() {
        return carbs;
    }

    public void setCarbs(long carbs) {
        this.carbs = carbs;
    }

    public long getCookTime() {
        return cookTime;
    }

    public void setCookTime(long cookTime) {
        this.cookTime = cookTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getFat() {
        return fat;
    }

    public void setFat(long fat) {
        this.fat = fat;
    }

    public long getFibre() {
        return fibre;
    }

    public void setFibre(long fibre) {
        this.fibre = fibre;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public long getKcal() {
        return kcal;
    }

    public void setKcal(long kcal) {
        this.kcal = kcal;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public long getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(long prepTime) {
        this.prepTime = prepTime;
    }

    public long getProtein() {
        return protein;
    }

    public void setProtein(long protein) {
        this.protein = protein;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getSalt() {
        return salt;
    }

    public void setSalt(long salt) {
        this.salt = salt;
    }

    public long getSaturates() {
        return saturates;
    }

    public void setSaturates(long saturates) {
        this.saturates = saturates;
    }

    public long getSugars() {
        return sugars;
    }

    public void setSugars(long sugars) {
        this.sugars = sugars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
