package com.elouazzani.myapplicationtest.model;

public class Repository {
    private String repName;
    private String repDescription;
    private double numbersOfStars;
    private String username;
    private String avatarUrl;

    public Repository(String repName, String repDescription, double numbersOfStars,
    String username, String avatarUrl) {
        this.repName=repName;
        this.repDescription=repDescription;
        this.numbersOfStars=numbersOfStars;
        this.username=username;
        this.avatarUrl=avatarUrl;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public double getNumbersOfStars() {
        return numbersOfStars;
    }

    public void setNumbersOfStars(double numbersOfStars) {
        this.numbersOfStars = numbersOfStars;
    }

    public String getRepDescription() {
        return repDescription;
    }

    public void setRepDescription(String repDescription) {
        this.repDescription = repDescription;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
