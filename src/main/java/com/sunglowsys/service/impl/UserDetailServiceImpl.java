package com.sunglowsys.service.impl;

import com.sunglowsys.domain.User;
import com.sunglowsys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private  UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =    userRepository.findUserByEmail(email);
        if (user==null) {
            throw new UsernameNotFoundException("user could not find");
        }else {
            return new CustomUserDetais(user);
        }
    }
}
