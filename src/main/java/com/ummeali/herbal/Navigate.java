package com.ummeali.herbal;

public class Navigate {

    public static final String REDIRECT = "redirect:";

    public static final String toHomepage() {
        return "index";
    }

    public static final String toProducts() {
        return "products";
    }

    public static final String toLogin() {
        return "login";
    }

    public static final String toSignUpForm() {
        return "signup";
    }

    public static final String toProfile() {
        return "user/profile";
    }

    public static final String toBasket() {
        return "shopping-cart";
    }

    public static final String toPayments() {
        return "payment";
    }

    public static final String toOrder() {
        return "order";
    }
}
