package com.ummeali.herbal.basket;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class ProductQuantity {

    @Id
    private Integer productId;
    private Integer quantity;

    public ProductQuantity() {
        // NO-OPS
    }

    public ProductQuantity(Integer productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductQuantity that = (ProductQuantity) o;
        return Objects.equals(productId, that.productId) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, quantity);
    }

    @Override
    public String toString() { // This is used to print value of object fields rather than object reference.
        return "ProductQuantity{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
