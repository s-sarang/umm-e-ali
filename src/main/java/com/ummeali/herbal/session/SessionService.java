package com.ummeali.herbal.session;

import com.ummeali.herbal.user.Customer;
import com.ummeali.herbal.user.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private CustomerRepository customerRepository;
    private SessionRepository sessionRepository;

    public SessionService(CustomerRepository customerRepository, SessionRepository sessionRepository){
        this.customerRepository = customerRepository;
        this.sessionRepository = sessionRepository;
    }

    public String login(String username, String password){
        if(username == null || password == null){
            throw new IllegalArgumentException("Please enter username and password");
        }
        Customer customer = customerRepository.findByEmailId(username);
        if(customer == null || !password.equals(customer.getPassword())){
            throw new IllegalArgumentException("Username or password is invalid.");
        }
        sessionRepository.save(Session.builder()
                        .userId(customer.getCustomerId())
                        .status("Logged In")
                .build());
        return sessionRepository.findByUserId(customer.getCustomerId()).getStatus();
    }

    public String logout(Integer userId){
        if(userId == null){
            throw new IllegalArgumentException("Invalid user");
        }
        Session session = sessionRepository.findByUserId(userId);
        session.setStatus("Logged Out");
        sessionRepository.save(session);
        return sessionRepository.findByUserId(userId).getStatus();
    }
}
