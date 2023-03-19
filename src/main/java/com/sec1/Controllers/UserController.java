package com.sec1.Controllers;

import com.sec1.Auth.AuthRequest;
import com.sec1.Services.JwtService;
import com.sec1.Services.UserService;
import com.sec1.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/add")
    public String adUser(@RequestBody User user) {
        return service.addUser(user);
    }
    @PostMapping("/auth")
    public ResponseEntity<Object> auth(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return ResponseEntity.ok(jwtService.generateToken(authRequest.getEmail()));
            //return jwtService.generateToken(authRequest.getEmail());
        }
        else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
           //return "User not Found";
        }
    }
}
