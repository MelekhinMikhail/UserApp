package pro.sky.userapp.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.userapp.dao.UserDao;
import pro.sky.userapp.models.User;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl out;

    public static final User NOT_EXIST_USER = new User("Nikolay", "435345", "123@fff.rt");
    public static final User EXIST_USER = new User("Ivan", "435345", "123@fff.rt");

    @Test
    void shouldReturnFalseWhenUserIsNull() {
        Assertions.assertFalse(out.checkUserExist(null));
    }

    @Test
    void shouldReturnFalseWhenUserIsNotExist() {
        Mockito.when(userDao.getUserByName(NOT_EXIST_USER.getName()))
                .thenReturn(null);
        Assertions.assertFalse(out.checkUserExist(NOT_EXIST_USER));
        Mockito.verify(userDao, Mockito.times(1)).getUserByName(NOT_EXIST_USER.getName());
    }

    @Test
    void shouldReturnTrueWhenUserIsExist() {
        Mockito.when(userDao.getUserByName(EXIST_USER.getName()))
                .thenReturn(EXIST_USER.getName());
        Assertions.assertTrue(out.checkUserExist(EXIST_USER));
        Mockito.verify(userDao, Mockito.times(1)).getUserByName(EXIST_USER.getName());
    }
}