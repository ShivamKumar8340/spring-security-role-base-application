package com.sunglowsys.resources;

import com.sunglowsys.domain.User;
import com.sunglowsys.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody User user) {
       userService.save(user);
       return ResponseEntity
               .status(HttpStatus.CREATED)
               .build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        if (user.getId()==null) {
            throw new RuntimeException("id must not be null");
        }
        userService.save(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<User>> findUser(@PathVariable Long id) {
        Optional<User> result = userService.findOne(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    @GetMapping("/get")
    public ResponseEntity<Page<User>> getUsers(Pageable pageable) {
       Page<User> result= userService.findAll(PageRequest.of(0,5));
       return ResponseEntity
               .status(HttpStatus.OK)
               .body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
