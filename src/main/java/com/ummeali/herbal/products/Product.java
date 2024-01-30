package com.ummeali.herbal.products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import org.checkerframework.checker.units.qual.C;

@Table(name = "PRODUCT")
@Entity
@Builder
public class Product {

    public Product(){
        // NO-OPS - required for Spring JPA.
    }

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer productId; // Unique identifier for a product.
    private String productName; // Name of product.
    private String productDescription; // A brief description of product
    private String productImageUrl; // Product image location
    private Float price; // Selling price of product.
    private Integer stock; // Inventory How many products are available?
    private String status; // Status of product, e.g. Available, Sold Out or Pre-Order Only

    // IDE Autogenerated - Constructors, Getters, Setters, Equals, Hash Code And ToString

    public Product(Integer productId, String productName, String productDescription, String productImageUrl, Float price, Integer stock, String status) { // All argument constructor
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImageUrl = productImageUrl;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() { // This is used to print value of object fields rather than object reference when logging.
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", status='" + status + '\'' +
                '}';
    }
}
