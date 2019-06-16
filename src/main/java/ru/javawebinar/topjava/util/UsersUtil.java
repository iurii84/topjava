package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

public class UsersUtil {

    public static final List<User> USERS = Arrays.asList(
            new User(1, "Catrine", "cat@gmail.com", "123", Role.ROLE_ADMIN),
            new User(2, "Johny", "johny@mail.ru", "321", Role.ROLE_USER),
            new User(3, "Michael", "michael555@abracadabra.com", "veryStrongPassword", Role.ROLE_USER)
    );

}
