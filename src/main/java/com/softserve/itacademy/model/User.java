package com.softserve.itacademy.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "The first_name cannot be empty")
    @Column(nullable = false)
    private String first_name;

    @NotBlank(message = "The last_name cannot be empty")
    @Column(nullable = false)
    private String last_name;

    @NotBlank(message = "The email cannot be empty")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "The password cannot be empty")
    @Column(nullable = false, unique = true)
    private String password;

    @ManyToOne()
    @JoinColumn(name = "Role_id")
    private Role role;

    public User() {
    }

    public User(int id, String first_name, String last_name, String email, String passport, Role role) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = passport;
        this.role = role;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassport(String passport) {
        this.password = passport;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassport() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
