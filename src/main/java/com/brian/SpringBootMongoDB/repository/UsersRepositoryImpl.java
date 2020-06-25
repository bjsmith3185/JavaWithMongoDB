package com.brian.SpringBootMongoDB.repository;

import com.brian.SpringBootMongoDB.document.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
//import com.mongodb.WriteResult;

public class UsersRepositoryImpl implements ICustomUpdatUser {


    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Users updateUser(Users users, Integer id) {

        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();;
        update.set("id", users.getId());
        update.set("name", users.getName());
        update.set("teamName", users.getTeamName());


//       WriteResult result = mongoTemplate.updateFirst(query, update, Users.class);
        mongoTemplate.updateFirst(query, update, Users.class);

        return null;

    }



}
