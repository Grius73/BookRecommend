package com.wudi.model;

public class Rate extends RateKey {
    private Integer rating;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rating=" + rating +
                '}';
    }
}