package dataproject.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAllUsers();

    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
       return userService.getUserById(id);
    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        userService.create(user);
        return user;
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/by-email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

}
