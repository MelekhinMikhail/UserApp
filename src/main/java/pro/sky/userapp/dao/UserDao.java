package pro.sky.userapp.dao;

import pro.sky.userapp.models.User;

import java.util.List;

public interface UserDao {


    String getUserByName(String name);

    List<User> getAllUsers();
}
