package com.ummeali.herbal.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

import java.util.Objects;


@Table(name = "USER")
@Entity
@Builder
public class User {

    @Id
    private Integer userId;
    private String title;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String userName;
    private String password;
    private String telephone;
    private String mobile;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String country;

    public User() {
        // NO-OPS
    }

    public User(int userId, String title, String firstName, String lastName, String dateOfBirth, String userName, String password, String telephone, String mobile, String email, String addressLine1, String addressLine2, String addressLine3, String country) {
        this.userId = userId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;
        this.password = password;
        this.telephone = telephone;
        this.mobile = mobile;
        this.email = email;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.country = country;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(title, user.title) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(telephone, user.telephone) && Objects.equals(mobile, user.mobile) && Objects.equals(email, user.email) && Objects.equals(addressLine1, user.addressLine1) && Objects.equals(addressLine2, user.addressLine2) && Objects.equals(addressLine3, user.addressLine3) && Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, title, firstName, lastName, dateOfBirth, userName, password, telephone, mobile, email, addressLine1, addressLine2, addressLine3, country);
    }

    @Override
    public String toString() {  // This is used to print value of object fields rather than object reference when logging.
        return "User{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + "*" + '\'' + // Password is being masked from printed for security.
                ", telephone='" + telephone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", addressLine3='" + addressLine3 + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public void validateUser(){
        if(this.getTitle() == null){
            throw new IllegalArgumentException("Title is required.");
        }
        if(this.getFirstName() == null){
            throw new IllegalArgumentException("First name is required.");
        }
        if(this.getFirstName() == null){
            throw new IllegalArgumentException("Last name is required.");
        }
        if(this.getFirstName() == null){
            throw new IllegalArgumentException("User name is required.");
        }
        if(this.getFirstName() == null){
            throw new IllegalArgumentException("Password is required.");
        }
    }
}
