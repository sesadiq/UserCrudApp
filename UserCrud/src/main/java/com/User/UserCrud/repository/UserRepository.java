package com.User.UserCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.User.UserCrud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
 
}
