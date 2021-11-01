package com.snehil.questquiz.service.impl;

import com.snehil.questquiz.entity.User;
import com.snehil.questquiz.entity.UserRole;
import com.snehil.questquiz.repository.RoleRepository;
import com.snehil.questquiz.repository.UserRepository;
import com.snehil.questquiz.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {


    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createUser(final User user, final Set<UserRole> userRoles) {
        User user1=userRepository.findByUserId(user.getUserId());
        if(user1!=null){
            log.info("User with id {} is already present",user.getUserId());
        } else {
            for(UserRole userRole:userRoles){
                roleRepository.save(userRole.getRole());
            }
            user.getUserRole().addAll(userRoles);

            user1=this.userRepository.save(user);
            log.info("New user is created with id {}",user1.getUserId());
        }
    }

    @Override
    public Optional<User> getUser(String userId) {
        return Optional.of(userRepository.findByUserId(userId));
    }

    @Override
    public User updateUser(User user, String id){
        if(getUser(id).isPresent()){
            return userRepository.save(user);
        } else{
            return null;
        }
    }
}
