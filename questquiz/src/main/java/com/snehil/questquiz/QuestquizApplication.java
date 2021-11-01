package com.snehil.questquiz;

import com.snehil.questquiz.entity.Role;
import com.snehil.questquiz.entity.User;
import com.snehil.questquiz.entity.UserRole;
import com.snehil.questquiz.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Slf4j
public class QuestquizApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(QuestquizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("running....");
		User user = new User();
		user.setUserId("guruji_01");
		user.setEmail("gurus@gmail.com");
		user.setFirstName("sneh");
		user.setImagePath("snehl.png");
		user.setPassword("alexa");
		user.setLastName("agre");
		user.setPhone("36378288299");
		Role role=new Role();
		role.setRoleName("participant");
		role.setId(3);
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		Set<UserRole> userRoles=new HashSet<>();
		userRoles.add(userRole);
		System.out.println(userRoles);
		log.debug("ok till here");
		this.userService.createUser(user,userRoles);
	}
}
