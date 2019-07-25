package com.myapp.api.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.api.entities.sql.User;


public interface IUserRepository extends JpaRepository<User, Integer> {

}
