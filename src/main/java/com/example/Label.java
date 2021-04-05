package com.example;

public class Label {

    private long mealid;
    private boolean pre;
    private boolean post;
    private boolean recovery;
    private boolean healthy;

    public Label(long mealid, boolean pre, boolean post, boolean recovery, boolean healthy) {
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
