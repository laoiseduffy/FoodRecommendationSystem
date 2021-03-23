package com.example;

import javax.persistence.*;

@Entity
@Table(name = "labelledrecipes")
public class LabelledRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mealid;

    @Column(name = "pre")
    private boolean pre;

    @Column(name = "post")
    private boolean post;

    @Column(name = "recovery")
    private boolean recovery;

    @Column(name = "healthy")
    private boolean healthy;

    public LabelledRecipe() {
    }

    public LabelledRecipe(long mealid, boolean pre, boolean post, boolean recovery, boolean healthy) {
        this.mealid = mealid;
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
