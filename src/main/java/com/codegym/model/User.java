package com.codegym.model;


import com.codegym.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size( max = 50)
    private String username;

    @JsonIgnore
    @NotBlank

    private String password;


    //    @Size(max = 50)
//    @Email
    private String email;

    @NotBlank
    @Size(min = 9, max = 11)
    private String phone;
    @NotBlank
    @Size(max = 50)
    private  String fullname;
    private String status;

    @Size(max = 100)
    private String address;
    @Lob
    private String avatar;
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Role> roles = new HashSet<>();
    @OneToMany (fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "user")
    @JsonIgnore
    private Set<UpdateTime> SetupdateTimes= new HashSet<>();

    public User() {
    }

//    public User(String username, String fullname, String encode, String email, String phone, String address) {
//
//    }


    public User(@NotBlank @Size(max = 50) String username, @NotBlank @Size(max = 50) String fullname, @NotBlank String password, @NotBlank String email, @NotBlank @Size(min = 9, max = 11) String phone, @NotBlank @Size(max = 100) String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.fullname = fullname;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<UpdateTime> getSetupdateTimes() {
        return SetupdateTimes;
    }

    public void setSetupdateTimes(Set<UpdateTime> setupdateTimes) {
        SetupdateTimes = setupdateTimes;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setAvatar() {
    }
}
