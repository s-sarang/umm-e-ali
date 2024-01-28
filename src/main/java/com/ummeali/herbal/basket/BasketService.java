package com.ummeali.herbal.basket;

import com.ummeali.herbal.user.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The Basket Service is used to handle all basket related transactions. This service allows user to:
 *
 * 1. Create a new basket.
 * 2. Update (add or remove) products with its respective quantities in the basket.
 * 3. Retrieve the contents of the basket.
 *
 * The 'delete' method is also exposed here for cleaning up the database for baskets which are no longer need.
 *
 */
@Slf4j
@Service
public class BasketService {

    private BasketRepository basketRepository;
    private CustomerRepository customerRepository;

    public BasketService(BasketRepository basketRepository, CustomerRepository customerRepository){
        this.basketRepository = basketRepository;
        this.customerRepository = customerRepository;
    }

    /**
     * Creates a new shopping basket for user.
     *
     * @param userId
     * @return
     */
    public int create(final int userId){
        //validateUser(userId); // Check that the user is a valid user.
        Basket userBasket = basketRepository.findByCustomerId(userId); // Check if user has an existing basket. The user can only have 1 basket at a time.
        if(userBasket != null){ // If user has an existing basket, then return the basket id as there is no need to create a new one.
            return userBasket.getBasketId();
        }
        Basket emptyBasket = Basket.builder() // Create an empty basket for the user.
                .customerId(userId)
                .status("Pending")
                .basketId(null).build();
        basketRepository.save(emptyBasket); // Persist the empty basket in database.
        Basket userEmptyBasket = basketRepository.findByCustomerId(userId); // Retrieve the empty basket from database.
        if(userEmptyBasket == null){ // Edge case - check that the empty basket is associated with the user and successfully retrieved.
            throw new RuntimeException("Failed to create a new basket for user: " + userId);
        }
        return userEmptyBasket.getBasketId(); // Return basketId.
    }

    /**
     * Retrieve the user's basket.
     *
     * @param customerId
     */
    public Basket get(final Integer customerId){
        if(customerId == 0){
            Basket guestBasket = basketRepository.findByCustomerId(0);
            if(guestBasket == null){  // If no basket is present for the user, then create a new empty basket.
                int newGuestBasket = create(0);
                return basketRepository.findById(newGuestBasket)
                        .orElseThrow(() -> new RuntimeException("Failed to retrieve basket for customer: " + customerId)); // Edge case - if both retrieve and create fails. This is unlikely and unreachable.
            }
            return guestBasket;
        }

        return basketRepository // Retrieve and return the user's basket.
                .findByCustomerId(customerId);
    }

    /**
     * Update a product with given quantity to a user's basket.
     *
     * @param productId
     * @param quantity
     */
    public void update(int basketId, final int userId, final int productId, final int quantity){
        Basket userBasket = get(userId);
        if("Paid".equals(userBasket.getStatus())){ // Check basket status. If basket status is Paid, that means the user has checked out and the basket can no longer be modified.
            throw new RuntimeException("The basket is already checked out.");
        }
        List<ProductQuantity> productsInBasket = userBasket.getProductQuantity();
        if(productsInBasket == null){ // Check if any product is present in basket.
            productsInBasket = new ArrayList<>(); // Create a new ArrayList if no products exist in basket.
        }
        if(quantity == 0){ // If user reduces the quantity of given product to 0, then remove the product from the basket.
            productsInBasket.removeIf(productQuantity -> productId == productQuantity.getProductId());
        } else if(quantity > 0){ // If quantity of given product is non-zero, then update quantity value of given product in the basket.
            productsInBasket.forEach(productQuantity -> {
                if(productId == productQuantity.getProductId()){
                    productQuantity.setQuantity(quantity);
                }
            });
        } else { // Edge case - if negative quantity is specified, then it is a bad request.
            throw new IllegalArgumentException("Quantity of product cannot be negative.");
        }
        Basket updatedBasket = Basket.builder()
                .basketId(basketId)
                .customerId(userId)
                .productQuantity(productsInBasket)
                .status("Pending")
                .build();
        basketRepository.save(updatedBasket); // Persist the updated basket in the database.
    }

    /**
     * Deletes a user's basket if status of basket is Paid.
     *
     * @param basketId
     * @param userId
     */
    public void delete(int basketId, final int userId){
        Basket userBasket = get(userId);
        if("Paid".equals(userBasket.getStatus())){
            basketRepository.delete(userBasket);
        }
    }

    /**
     * Check given user is valid.
     *
     * @param customerId
     */
    private void validateUser(final Integer customerId){
        customerRepository
                .findById(customerId)
                .orElseThrow(() -> new RuntimeException("Failed to retrieve user: " + customerId));
    }
}
