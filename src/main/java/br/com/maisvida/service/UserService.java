package br.com.maisvida.service;

import br.com.maisvida.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    Page<User> findByEmail(String email);

    Page<User> findByFirstName(String name);

    User findById(Long id);

    List<User> findAll();

    void delete(Long id);

    void save(User user);

    void update(User user);
}
