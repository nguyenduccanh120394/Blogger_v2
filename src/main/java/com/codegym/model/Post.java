package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date date;
    private String content;
    private String image;
    private String description;
    private String status;
    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(Long id, String title, Date date, String content, String image, String description, String status, User user) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
        this.image = image;
        this.description = description;
        this.status = status;
        this.user = user;
    }

    public Post(String title, Date date, String content, String image, String description, String status, User user) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.image = image;
        this.description = description;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
