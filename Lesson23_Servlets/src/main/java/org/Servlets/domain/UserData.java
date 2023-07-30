package org.Servlets.domain;

import org.Servlets.exception.UserAlreadyExistException;
import org.Servlets.exception.UserLoginFailedException;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    private static Map<String, User> userMap = new HashMap<>();

    public void addUser(String login, String password, Integer age, String email) {
        if (login == null || login.isBlank() || password == null || password.isBlank()) {
            throw new UserLoginFailedException();
        }
        boolean exist = userMap.containsKey(login);
        if (exist) {
            throw new UserAlreadyExistException();
        }
        User user = new User(login, password, age, email);
        userMap.put(login, user);
    }

    public void checkPassword(String login, String password) {
        boolean exist = userMap.containsKey(login);
        if (exist) {
            User user = userMap.get(login);
            if (password.equals(user.getPassword())) {
                return;
            }
        }
        throw new UserLoginFailedException();
    }
}

