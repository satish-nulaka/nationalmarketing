package com.nationalmarketing.configuration;


import com.nationalmarketing.entity.User;
import com.nationalmarketing.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            User user = new User("satish", "Satish@19");
            userRepository.save(user);
        };
    }
}
