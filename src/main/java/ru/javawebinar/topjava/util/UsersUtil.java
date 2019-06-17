package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsersUtil {

    public static final List<User> USERS = Arrays.asList(
            new User("Catrine", "cat@gmail.com", "123", Role.ROLE_ADMIN),
            new User("Johny", "johny@mail.ru", "321", Role.ROLE_USER),
            new User("Michael", "michael555@abracadabra.com", "veryStrongPassword", Role.ROLE_USER)
    );

    public static List<User> sortByName(Collection<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }
}
