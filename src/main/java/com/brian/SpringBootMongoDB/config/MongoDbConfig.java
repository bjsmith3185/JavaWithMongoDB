package com.brian.SpringBootMongoDB.config;

import com.brian.SpringBootMongoDB.document.Users;
import com.brian.SpringBootMongoDB.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class MongoDbConfig {


//    @Bean
//    CommandLineRunner commandLineRunner(UsersRepository usersRepository) {
//
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                usersRepository.save(new Users(1, "brian", "a-team"));
//                usersRepository.save(new Users(2, "emmett", "a-team"));
//            }
//        };
//
//    }








}
