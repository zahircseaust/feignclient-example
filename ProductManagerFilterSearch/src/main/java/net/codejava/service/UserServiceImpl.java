package net.codejava.service;

import lombok.RequiredArgsConstructor;
import net.codejava.model.User;
import net.codejava.reposity.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> user = userRepository.findAll();
        return user;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User existUser = userRepository.findById(user.getId()).get();
        existUser.setFirstName(user.getFirstName());
        existUser.setLastName(user.getLastName());
        existUser.setAddress(user.getAddress());
        existUser.setSalary(user.getSalary());
        existUser.setEmailId(user.getEmailId());
        User updateUser = userRepository.save(existUser);
        return updateUser;
    }

    @Override
    public void deleteuser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> searchUserName(String firstName) {
        List<User> user = userRepository.findByFirstName(firstName);
        return user;
    }


}
