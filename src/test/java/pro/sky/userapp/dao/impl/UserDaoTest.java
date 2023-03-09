package pro.sky.userapp.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    public static final String INCORRECT_NAME_EMPTY = "";
    public static final String INCORRECT_NAME_TWO_SPACES = "  ";
    public static final String CORRECT_NAME_NOT_EXISTS = "User123";
    public static final String CORRECT_NAME_EXISTS = "Ivan";
    private final UserDaoImpl userDao = new UserDaoImpl();

    @Test
    void shouldReturnNullWhenNameIsEmptyOrIsBlankOrNull() {
        Assertions.assertNull(userDao.getUserByName(INCORRECT_NAME_EMPTY));
        Assertions.assertNull(userDao.getUserByName(INCORRECT_NAME_TWO_SPACES));
        Assertions.assertNull(userDao.getUserByName(null));
    }

    @Test
    void shouldReturnNameWhenNameIsCorrectAndNameIsExists() {
        Assertions.assertEquals(CORRECT_NAME_EXISTS, userDao.getUserByName(CORRECT_NAME_EXISTS));
    }

    @Test
    void shouldReturnNullWhenNameIsCorrectButNotExists() {
        Assertions.assertNull(userDao.getUserByName(CORRECT_NAME_NOT_EXISTS));
    }

    @Test
    void getAllUsers() {
        Assertions.assertTrue(userDao.getAllUsers().size() != 0);
    }
}