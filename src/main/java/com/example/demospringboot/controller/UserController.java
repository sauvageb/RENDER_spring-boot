package com.example.demospringboot.controller;

import com.example.demospringboot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @GetMapping
    public ResponseEntity<?> fetchUsers(){

        List<User> users = new ArrayList<>();
        // Générez 10 utilisateurs avec des informations aléatoires
        for (long i = 1; i <= 10; i++) {
            User user = generateRandomUser(i);
            users.add(user);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }

    private User generateRandomUser(long id) {
        String[] firstNames = {"John", "Jane", "Alice", "Bob", "Eva"};
        String[] lastNames = {"Smith", "Doe", "Johnson", "Brown", "Taylor"};
        String[] domains = {"example.com", "gmail.com", "yahoo.com", "hotmail.com"};

        Random random = new Random();

        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" +
                domains[random.nextInt(domains.length)];

        return new User(id, firstName, lastName, email);
    }

}
