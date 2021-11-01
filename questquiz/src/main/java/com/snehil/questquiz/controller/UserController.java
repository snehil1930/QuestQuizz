package com.snehil.questquiz.controller;


import com.snehil.questquiz.entity.Role;
import com.snehil.questquiz.entity.User;
import com.snehil.questquiz.entity.UserRole;
import com.snehil.questquiz.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.SecondaryTable;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    final UserService userService;

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<String> createUser(@RequestBody final User user){
        try{
           final Role role=new Role();
           role.setId(3);
           role.setRoleName("Normal");
           Set<UserRole> roles=new HashSet<>();
           UserRole userRole=new UserRole();
           userRole.setRole(role);
           userRole.setUser(user);
           roles.add(userRole);
           userService.createUser(user,roles);
        } catch (Exception e){
            return new ResponseEntity<>("Error in creating the new user", HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>("new User is Created",HttpStatus.OK);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<User> getUser(@PathVariable ("userid") String userId){
        User user;
        try{
            user=userService.getUser(userId).get();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("/{userid}")
    public ResponseEntity<User> updateUser(@PathVariable("userid")String userId,@RequestBody User user){
        var user1=Optional.of(userService.updateUser(user,userId));
        if(user1.isPresent()){
            return new ResponseEntity<>(user1.get(),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
