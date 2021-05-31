package com.example.jerusalemapp.model;

import java.util.ArrayList;

public class News {
    String status;
    int totalResults;
    ArrayList<Data>articles=new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public ArrayList<Data> getArticles() {
        return articles;
    }

    public class Data {
    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    String publishedAt;
    String content;

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getUrl() {
            return url;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String getContent() {
            return content;
        }
    }}