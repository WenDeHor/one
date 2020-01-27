package ua.onemace.prog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.onemace.prog.model.User;
import ua.onemace.prog.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User getEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void add(User user) {
        userRepository.save(user);
    }
}
