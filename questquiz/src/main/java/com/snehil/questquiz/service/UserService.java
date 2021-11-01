package com.snehil.questquiz.service;

import com.snehil.questquiz.entity.User;
import com.snehil.questquiz.entity.UserRole;

import java.util.Optional;
import java.util.Set;

public interface UserService {


    public void createUser(User user , Set<UserRole> userRoles) throws Exception;
    public Optional<User> getUser(String userId);
    public User updateUser(User user,String id);
}
