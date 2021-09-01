package com.codegym.model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class UpdateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date timeupdate;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public UpdateTime() {
    }

    public UpdateTime(Long id, Date timeupdate, User user) {
        this.id = id;
        this.timeupdate = timeupdate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimeupdate() {
        return timeupdate;
    }

    public void setTimeupdate(Date timeupdate) {
        this.timeupdate = timeupdate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
