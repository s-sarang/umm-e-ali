package com.ummeali.herbal.session;

import com.ummeali.herbal.user.Customer;
import com.ummeali.herbal.user.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private static final Integer GUEST_CUSTOMER_ID = 0;
    private CustomerRepository customerRepository;
    private SessionRepository sessionRepository;

    public SessionService(CustomerRepository customerRepository, SessionRepository sessionRepository){
        this.customerRepository = customerRepository;
        this.sessionRepository = sessionRepository;
    }

    public Session guestSession(){
        if(!sessionRepository.existsByCustomerId(GUEST_CUSTOMER_ID)){
            sessionRepository.save(Session.builder()
                    .customerId(GUEST_CUSTOMER_ID)
                    .status("Guest")
                    .build());
        }
        return sessionRepository.findByCustomerId(0);
    }

    @Transactional
    public Session login(String username, String password){
        if(username == null || password == null){
            throw new IllegalArgumentException("Please enter username and password");
        }
        Customer customer = customerRepository.findByEmailId(username);
        if(customer == null || !password.equals(customer.getPassword())){
            throw new IllegalArgumentException("Username or password is invalid.");
        }
        sessionRepository.save(Session.builder()
                        .customerId(customer.getCustomerId())
                        .status("Logged In")
                .build());
        sessionRepository.deleteByCustomerId(0);
        return sessionRepository.findByCustomerId(customer.getCustomerId());
    }

    @Transactional
    public Session logout(Integer customerId){
        if(customerId == null){
            throw new IllegalArgumentException("Invalid customer");
        }
        sessionRepository.deleteByCustomerId(customerId);
        return guestSession();
    }

    public Session getSession(Integer customerId){
        return sessionRepository.findByCustomerId(customerId);
    }
}
