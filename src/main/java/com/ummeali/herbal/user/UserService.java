package com.ummeali.herbal.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Create a new user.
     *
     * @param user
     */
    public int create(User user){
        User duplicateUser = userRepository.findByUserName(user.getUserName()); // Check if username is not already taken.
        if(duplicateUser != null){ // If username is already taken, then send exception message to user.
            throw new IllegalArgumentException("Username is already taken. Please try another one.");
        }
        userRepository.save(user); // Persist the user in database.
        return userRepository.findByUserName(user.getUserName()).getUserId(); // Return userId.
    }

    /**
     * Retrieve the user details.
     *
     * @param userId
     */
    public User get(int userId){
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User id not found"));
    }

    /**
     * Updates user information.
     *
     * @param user
     */
    public void update(User user){
        User updatedUser = get(user.getUserId()); // Retrieve user and update details.
        updatedUser.setTitle(user.getTitle());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setDateOfBirth(user.getDateOfBirth());
        updatedUser.setUserName(user.getUserName());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setTelephone(user.getTelephone());
        updatedUser.setMobile(user.getMobile());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setAddressLine1(user.getAddressLine1());
        updatedUser.setAddressLine2(user.getAddressLine2());
        updatedUser.setAddressLine3(user.getAddressLine3());
        updatedUser.setCountry(user.getCountry());
        userRepository.save(updatedUser); // Save user with updated details.
    }

    /**
     * Deletes a user.
     *
     * @param userId
     */
    public void delete(int userId){
        userRepository.deleteById(userId); // Delete user
    }
}
