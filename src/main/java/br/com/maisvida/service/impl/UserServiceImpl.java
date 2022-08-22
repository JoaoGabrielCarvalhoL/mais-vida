package br.com.maisvida.service.impl;

import br.com.maisvida.exception.UserException;
import br.com.maisvida.model.User;
import br.com.maisvida.repository.UserRepository;
import br.com.maisvida.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> findByEmail(String email) {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.ASC, "email");
        return userRepository.findUserByEmail(email, pageRequest);
    }

    @Override
    public Page<User> findByFirstName(String firstName) {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.ASC, "firstName");
        return userRepository.findUserByFirstName(firstName, pageRequest);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserException("User not found!"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(findById(id));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        save(user);
    }
}
