package com.snehil.questquiz.service;

import com.snehil.questquiz.entity.User;
import com.snehil.questquiz.entity.UserRole;

import java.util.Set;

public interface UserService {


    void createUser(User user , Set<UserRole> userRoles) throws Exception;
}
