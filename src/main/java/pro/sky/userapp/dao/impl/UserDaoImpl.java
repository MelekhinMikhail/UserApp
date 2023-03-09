package pro.sky.userapp.dao.impl;

import org.springframework.stereotype.Service;
import pro.sky.userapp.dao.UserDao;
import pro.sky.userapp.models.User;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    private static final List<User> users = new LinkedList<>();

    public UserDaoImpl() {
        users.add(new User("Ivan", "qwerty123", "prorabbit@mail.go"));
        users.add(new User("Peter", "qwerty228", "iloveicecream@kmail.gol"));
        users.add(new User("Jessica", "qwerty741", "blackcar@gmail.no"));
        users.add(new User("John", "qwerty356", "minecrafter@jomail.ok"));
        users.add(new User("Maria", "qwerty000", "maria@mail.ru"));
    }

    @Override
    public String getUserByName(String name) {
        if (users.isEmpty() || name == null || name.isEmpty() || name.isBlank()) {
            return null;
        }
        for (User user : users) {
            if (user.getName().equals(name)) {
                return name;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
