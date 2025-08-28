package week2.one;

import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int publishingYear;
    private double rating;
    private ArrayList<String> reviews;
    static int i = 1;

    public Book(String title, String author, int publishingYear) {
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
        this.reviews = new ArrayList<>();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublishingYear() { return publishingYear; }

    public void displayInfo() {
        System.out.printf(i + " " + getTitle() + " by " + getAuthor() + " (%d)\n", getPublishingYear());
        i++;
    }

    public void displayAuthor() {
        System.out.printf("🔶 The Author " + getAuthor() + " Book: " + getTitle() + " (%d)\n", getPublishingYear());
    }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public ArrayList<String> getReviews() { return reviews; }
    public void addReview(String review) { reviews.add(review); }
}