package com.ummeali.herbal.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

import java.util.Objects;


@Table(name = "CUSTOMER")
@Entity
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer customerId;
    private String title;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String userName;
    private String password;
    private String telephone;
    private String mobile;
    private String emailId;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String country;

    public Customer() {
        // NO-OPS
    }

    public Customer(int customerId, String title, String firstName, String lastName, String dateOfBirth, String userName, String password, String telephone, String mobile, String emailId, String addressLine1, String addressLine2, String addressLine3, String country) {
        this.customerId = customerId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;
        this.password = password;
        this.telephone = telephone;
        this.mobile = mobile;
        this.emailId = emailId;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.country = country;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int userId) {
        this.customerId = userId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String email) {
        this.emailId = email;
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
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(title, customer.title) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(dateOfBirth, customer.dateOfBirth) && Objects.equals(userName, customer.userName) && Objects.equals(password, customer.password) && Objects.equals(telephone, customer.telephone) && Objects.equals(mobile, customer.mobile) && Objects.equals(emailId, customer.emailId) && Objects.equals(addressLine1, customer.addressLine1) && Objects.equals(addressLine2, customer.addressLine2) && Objects.equals(addressLine3, customer.addressLine3) && Objects.equals(country, customer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, title, firstName, lastName, dateOfBirth, userName, password, telephone, mobile, emailId, addressLine1, addressLine2, addressLine3, country);
    }

    @Override
    public String toString() {  // This is used to print value of object fields rather than object reference when logging.
        return "Customer{" +
                "customerId=" + customerId +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + "*" + '\'' + // Password is being masked from printed for security.
                ", telephone='" + telephone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", emailId='" + emailId + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", addressLine3='" + addressLine3 + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public void validateUser(){
        if(this.getEmailId() == null){
            throw new IllegalArgumentException("Email Id is required.");
        }
        if(this.getPassword() == null){
            throw new IllegalArgumentException("Password is required.");
        }
    }
}
