package com.nhnghia.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Enter your first name please.")
    @Size(min = 5, max = 45, message = "The first name must contain between 5 and 45 characters.")
    private String firstName;

    @NotBlank(message = "Enter your last name please.")
    @Size(min = 5, max = 45, message = "The last name must contain between 5 and 45 characters.")
    private String lastName;

    @Pattern(regexp = "^0[0-9]{9}$", message = "Invalid phone number please re-enter.")
    private String phoneNumber;

    @Min(value = 18, message = "You are not old enough.")
    private int age;

    @Pattern(regexp = "^[a-z0-9]+[\\\\.]?+[a-z0-9]+[@][a-z]+[.][a-z]+([.][a-z]+)?$", message = "Invalid email please re-enter.")
    private String email;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
