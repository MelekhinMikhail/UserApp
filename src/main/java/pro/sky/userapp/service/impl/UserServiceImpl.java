package pro.sky.userapp.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.userapp.dao.UserDao;
import pro.sky.userapp.models.User;
import pro.sky.userapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean checkUserExist(User user) {
        if (user == null) {
            return false;
        }
        String result = userDao.getUserByName(user.getName());
        return result != null;
    }
}
