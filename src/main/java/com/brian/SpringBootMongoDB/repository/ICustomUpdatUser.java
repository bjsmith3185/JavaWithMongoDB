package com.brian.SpringBootMongoDB.repository;

import com.brian.SpringBootMongoDB.document.Users;

public interface ICustomUpdatUser {

    Users updateUser(Users users, Integer id);

}
