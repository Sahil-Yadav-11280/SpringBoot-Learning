package com.sahil.taskmanager;

import com.sahil.taskmanager.model.User;
import org.springframework.boot.CommandLineRunner;
import com.sahil.taskmanager.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntelliJApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntelliJApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository){
        return VastoLorde -> {
            if(userRepository.count()==0){
                User defaultUser = new User();
                defaultUser.setUsername("Sahil_admin");
                userRepository.save(defaultUser);
                System.out.println("✅Default user 'Sahil_admin' created in database!");
            }
        };
    }
}
