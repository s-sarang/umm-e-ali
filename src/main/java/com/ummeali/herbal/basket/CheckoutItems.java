package com.ummeali.herbal.basket;

import java.util.List;

public class CheckoutItems {

    private String checkoutTotal;
    private List<Item> items;

    public CheckoutItems(String checkoutTotal, List<Item> items) {
        this.checkoutTotal = checkoutTotal;
        this.items = items;
    }

    public String getCheckoutTotal() {
        return checkoutTotal;
    }

    public void setCheckoutTotal(String checkoutTotal) {
        this.checkoutTotal = checkoutTotal;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CheckoutItems{" +
                "checkoutTotal='" + checkoutTotal + '\'' +
                ", items=" + items +
                '}';
    }
}
