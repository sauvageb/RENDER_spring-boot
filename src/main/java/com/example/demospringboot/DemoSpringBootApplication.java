package com.example.demospringboot;

import com.example.demospringboot.model.Address;
import com.example.demospringboot.model.User;
import com.example.demospringboot.repository.AddressRepository;
import com.example.demospringboot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }


    @Bean
    @Transactional
    CommandLineRunner runner(UserRepository userRepository, AddressRepository addressRepository) {
        return args -> {

            User u1 = new User("Boris", "Sauvage", "sauvageboris.pro@gmail.com");
            Address address1 = new Address("Lille");

            u1.setAddressList(Arrays.asList(address1));
            address1.setUser(u1);
            userRepository.save(u1);


            User u2 = new User("Jane", "Doe", "sauvageboris.pro@gmail.com");
            Address address2 = new Address("Paris");
            u2.setAddressList(Arrays.asList(address2));
            address2.setUser(u2);
            userRepository.save(u2);
        };
    }
}
