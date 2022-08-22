package br.com.maisvida.controller;

import br.com.maisvida.model.User;
import br.com.maisvida.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findByName")
    @ResponseStatus(HttpStatus.OK)
    public Page<User> findByName(@RequestParam("name") String name) {
        return userService.findByFirstName(name);
    }

    @GetMapping("/findByEmail")
    @ResponseStatus(HttpStatus.OK)
    public Page<User> findByEmail(@RequestParam("email") String email) {
        return userService.findByEmail(email);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody User user) {
        userService.update(user);
    }

}
