package com.ummeali.herbal.session;

import com.ummeali.herbal.user.User;
import com.ummeali.herbal.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    public SessionService(UserRepository userRepository, SessionRepository sessionRepository){
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public String login(String username, String password){
        if(username == null || password == null){
            throw new IllegalArgumentException("Please enter username and password");
        }
        User user = userRepository.findByUserName(username);
        if(user == null || !password.equals(user.getPassword())){
            throw new IllegalArgumentException("Username or password is invalid.");
        }
        sessionRepository.save(Session.builder()
                        .userId(user.getUserId())
                        .status("Logged In")
                .build());
        return sessionRepository.findByUserId(user.getUserId()).getStatus();
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
