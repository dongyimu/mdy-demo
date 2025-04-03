package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int daysEstablished;
    private int articlesCount;
    private int commentsCount;
    private int tagsCount;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDaysEstablished() {
        return daysEstablished;
    }

    public void setDaysEstablished(int daysEstablished) {
        this.daysEstablished = daysEstablished;
    }

    public int getArticlesCount() {
        return articlesCount;
    }

    public void setArticlesCount(int articlesCount) {
        this.articlesCount = articlesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getTagsCount() {
        return tagsCount;
    }

    public void setTagsCount(int tagsCount) {
        this.tagsCount = tagsCount;
    }
}    