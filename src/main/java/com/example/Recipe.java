package com.example;

public class Recipe {

    private long mealid;
    private long carbs;
    private double cookTime;
    private String description;
    private long fat;
    private long fibre;
    private String image_url;
    private String[] ingredients;
    private long kcal;
    private String[] keywords;
    private String method;
    private double prepTime;
    private long protein;
    private double rating;
    private long salt;
    private long saturates;
    private long sugars;
    private String title;
    private double proteinPercentage;
    private double carbsPercentage;
    private double fatPercentage;
    private boolean pre;
    private boolean post;
    private boolean recovery;
    private boolean healthy;

    public Recipe(long mealid, long carbs, double cookTime, String description, long fat, long fibre, String image_url, String[] ingredients, long kcal, String[] keywords, String method, double prepTime, long protein, double rating, long salt, long saturates, long sugars, String title, double proteinPercentage, double carbsPercentage, double fatPercentage, boolean pre, boolean post, boolean recovery, boolean healthy) {
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
        this.proteinPercentage = proteinPercentage;
        this.carbsPercentage = carbsPercentage;
        this.fatPercentage = fatPercentage;
        this.pre = pre;
        this.post = post;
        this.recovery = recovery;
        this.healthy = healthy;
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

    public double getCookTime() {
        return cookTime;
    }

    public void setCookTime(double cookTime) {
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

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public long getKcal() {
        return kcal;
    }

    public void setKcal(long kcal) {
        this.kcal = kcal;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(double prepTime) {
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

    public double getProteinPercentage() {
        return proteinPercentage;
    }

    public void setProteinPercentage(double proteinPercentage) {
        this.proteinPercentage = proteinPercentage;
    }

    public double getCarbsPercentage() {
        return carbsPercentage;
    }

    public void setCarbsPercentage(double carbsPercentage) {
        this.carbsPercentage = carbsPercentage;
    }

    public double getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(double fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public boolean isPre() {
        return pre;
    }

    public void setPre(boolean pre) {
        this.pre = pre;
    }

    public boolean isPost() {
        return post;
    }

    public void setPost(boolean post) {
        this.post = post;
    }

    public boolean isRecovery() {
        return recovery;
    }

    public void setRecovery(boolean recovery) {
        this.recovery = recovery;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }
}
