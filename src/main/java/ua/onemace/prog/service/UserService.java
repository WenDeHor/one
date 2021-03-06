package ua.onemace.prog.service;



import ua.onemace.prog.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getOne(String name);
    User getEmail(String email);

    void add(User user);
}
