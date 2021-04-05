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

    public long getCarbs() {
        return carbs;
    }

    public double getCookTime() {
        return cookTime;
    }

    public String getDescription() {
        return description;
    }

    public long getFat() {
        return fat;
    }

    public long getFibre() {
        return fibre;
    }

    public String getImage_url() {
        return image_url;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public long getKcal() {
        return kcal;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public String getMethod() {
        return method;
    }

    public double getPrepTime() {
        return prepTime;
    }

    public long getProtein() {
        return protein;
    }

    public double getRating() {
        return rating;
    }

    public long getSalt() {
        return salt;
    }

    public long getSaturates() {
        return saturates;
    }

    public long getSugars() {
        return sugars;
    }

    public String getTitle() {
        return title;
    }

    public double getProteinPercentage() {
        return proteinPercentage;
    }

    public double getCarbsPercentage() {
        return carbsPercentage;
    }

    public double getFatPercentage() {
        return fatPercentage;
    }

    public boolean isPre() {
        return pre;
    }

    public boolean isPost() {
        return post;
    }

    public boolean isRecovery() {
        return recovery;
    }

    public boolean isHealthy() {
        return healthy;
    }

}
