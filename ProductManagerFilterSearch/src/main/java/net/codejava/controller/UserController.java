package net.codejava.controller;

import lombok.RequiredArgsConstructor;
import net.codejava.dto.UserDto;
import net.codejava.dto.UserName;
import net.codejava.model.User;
import net.codejava.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private ModelMapper modelMapper;

    private final UserServiceImpl userService;

    //without dto
    @GetMapping(value = "/getAll-users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //using dto
    @GetMapping(value = "/getAll")
    public List<UserDto> getAllUserUsingDto() {
        return userService.getUsers().stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/create-user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User saveUser = userService.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }


    @PutMapping(value = "update-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteuser(id);
        return new ResponseEntity<>("delete successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public List<UserDto> getUserByFirstName(@RequestParam String firstName) {
        return userService.searchUserName(firstName).stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }
}
