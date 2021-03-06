package com.assignment.bookstore.repository;

import com.assignment.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserReposirotry  extends JpaRepository<User,Integer> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByName(String name);
}
