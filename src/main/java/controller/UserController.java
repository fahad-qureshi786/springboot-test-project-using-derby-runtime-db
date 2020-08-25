package controller;

import dao.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    //inject respository into controller
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/saveUsers")
    public String saveUsers(@RequestBody List<User> users){
        userRepository.saveAll(users);
        return users.size()+" users saved";
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/getUserByUsername/{name}")
    public User findUserByName(@PathVariable String username){
        return userRepository.findUserByUsername(username);
    }

}
