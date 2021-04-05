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
