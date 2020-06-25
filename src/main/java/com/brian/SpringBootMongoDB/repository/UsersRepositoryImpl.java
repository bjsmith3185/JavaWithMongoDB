package com.brian.SpringBootMongoDB.repository;

import com.brian.SpringBootMongoDB.document.Users;
import com.mongodb.WriteConcernResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
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
        Update update = new Update();
        update.set("id", users.getId());
        update.set("name", users.getName());
        update.set("teamName", users.getTeamName());

        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Users.class);

        return users;

    }

    @Override
    public Users findOneAndModify(Users users, Integer id) {


        Query query = new Query(Criteria.where("id").is(id));

        Update update = new Update();
        update.set("id", users.getId());
        update.set("name", users.getName());
        update.set("teamName", users.getTeamName());

        //FindAndModifyOptions().returnNew(true) = newly updated document
        //FindAndModifyOptions().returnNew(false) = old document (not update yet)
        Users updatedUser = mongoTemplate.findAndModify(
                query, update,
                new FindAndModifyOptions().returnNew(true), Users.class);
        System.out.println("update user: " + updatedUser);


        return updatedUser;
    }












}
