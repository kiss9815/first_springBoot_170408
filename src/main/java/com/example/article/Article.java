package com.example.article;

import java.time.OffsetDateTime;

/**
 * Created by EOM on 2017-04-08.
 */
public class Article{

    private Long id;
    private String title;
    private String author;
    private String body;
    private OffsetDateTime created; // 자바8에서 새로 생긴 객체 LocalDateTime

    public Article() {

    }


    public Article(Long id, String title, String author, String body) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.body = body;
        this.created = OffsetDateTime.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public OffsetDateTime getCreated() {
        return created;
    }
}
