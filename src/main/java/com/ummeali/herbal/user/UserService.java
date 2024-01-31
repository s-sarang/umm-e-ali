package com.ummeali.herbal.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private CustomerRepository customerRepository;

    public UserService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    /**
     * Create a new user.
     *
     * @param customer
     */
    public int create(Customer customer){
        boolean duplicateUser = customerRepository.existsByEmailId(customer.getEmailId()); // Check if username is not already taken.
        if(duplicateUser){ // If username is already taken, then send exception message to user.
            throw new IllegalArgumentException("Username is already taken. Please try another one.");
        }
        customerRepository.save(customer); // Persist the user in database.
        return customerRepository.findByEmailId(customer.getEmailId()).getCustomerId(); // Return userId.
    }

    /**
     * Retrieve the user details.
     *
     * @param userId
     */
    public Customer get(int userId){
        return customerRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User id not found"));
    }

    /**
     * Updates user information.
     *
     * @param customer
     */
    public Customer update(Customer customer){
        Customer updatedCustomer = get(customer.getCustomerId()); // Retrieve user and update details.
        updatedCustomer.setTitle(customer.getTitle());
        updatedCustomer.setFirstName(customer.getFirstName());
        updatedCustomer.setLastName(customer.getLastName());
        updatedCustomer.setDateOfBirth(customer.getDateOfBirth());
        updatedCustomer.setUserName(customer.getUserName());
        updatedCustomer.setPassword(customer.getPassword());
        updatedCustomer.setTelephone(customer.getTelephone());
        updatedCustomer.setMobile(customer.getMobile());
        updatedCustomer.setEmailId(customer.getEmailId());
        updatedCustomer.setAddressLine1(customer.getAddressLine1());
        updatedCustomer.setAddressLine2(customer.getAddressLine2());
        updatedCustomer.setAddressLine3(customer.getAddressLine3());
        updatedCustomer.setCountry(customer.getCountry());
        return customerRepository.save(updatedCustomer); // Save user with updated details.
    }

    /**
     * Deletes a user.
     *
     * @param userId
     */
    public void delete(int userId){
        customerRepository.deleteById(userId); // Delete user
    }
}
