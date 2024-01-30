package com.ummeali.herbal.basket;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class ProductQuantity {

    @ManyToOne
    @JoinColumn(name="basketId")
    private Basket basket;
    @Id
    private Integer productId;
    private Integer quantity;

    public ProductQuantity() {
        // NO-OPS
    }

    public ProductQuantity(Basket basket, Integer productId, Integer quantity) {
        this.basket = basket;
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

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
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
    public String toString() {
        return "ProductQuantity{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
