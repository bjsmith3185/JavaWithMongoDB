package com.brian.SpringBootMongoDB.repository;

import com.brian.SpringBootMongoDB.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, Integer>, ICustomUpdatUser {
}
