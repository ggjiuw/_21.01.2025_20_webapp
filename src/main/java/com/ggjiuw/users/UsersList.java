package com.ggjiuw.users;

import java.util.ArrayList;
import java.util.List;

public class UsersList {
    static List<User> UsersData = new ArrayList<>();

    public static List<User> getUsers() {
        ArrayList<User> r = new ArrayList<>(UsersData);

        if (r.isEmpty())
            r.add(new User("admin", "1234"));

        return r;
    }

    public static synchronized void addUser(User u) {
        UsersData.add(u);
    }
}
