package br.com.maisvida.service.impl;

import br.com.maisvida.model.User;
import br.com.maisvida.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    public UserService userService;

    @Test
    public void should_return_users_by_first_name() {
        Page<User> users = userService.findByFirstName("vida");
        Assertions.assertThat(users).isNotNull();
    }

    @Test
    public void should_return_users_by_email() {
        Page<User> users = userService.findByEmail("maisvida@gmail.com");
        Assertions.assertThat(users).isNotNull();
    }
}
