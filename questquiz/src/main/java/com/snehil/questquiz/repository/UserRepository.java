package com.snehil.questquiz.repository;

import com.snehil.questquiz.entity.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

//    @Query(value="Select * from User where user_id=?1",nativeQuery = true)
     User findByUserId(String id);
      User findById(long id);
}
