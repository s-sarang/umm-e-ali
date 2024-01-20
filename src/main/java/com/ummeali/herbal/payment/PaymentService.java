package com.ummeali.herbal.payment;

import com.ummeali.herbal.basket.Basket;
import com.ummeali.herbal.basket.BasketRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private BasketRepository basketRepository;

    public PaymentService(BasketRepository basketRepository){
        this.basketRepository = basketRepository;
    }

    public String checkout(final Integer basketId){ // Update basket status to paid and return value.
        Basket updatedBasket = basketRepository.findById(basketId).orElseThrow(() -> new IllegalArgumentException("Invalid Basket"));
        updatedBasket.setStatus("Paid");
        basketRepository.save(updatedBasket);
        return basketRepository.findById(basketId).orElseThrow(() -> new IllegalArgumentException("Invalid Basket")).getStatus();
    }
}
