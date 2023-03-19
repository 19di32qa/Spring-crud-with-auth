package com.sec1.Services;

import com.sec1.User.User;
import com.sec1.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    PasswordEncoder encoder;

    public String addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "User is added";
    }

}
