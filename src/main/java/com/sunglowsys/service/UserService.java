package com.sunglowsys.service;

import com.sunglowsys.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    void save(User user);

    void update(User user);

    Optional<User> findOne(Long id);

    Page<User> findAll(Pageable pageable);

    void delete(Long id);
}
