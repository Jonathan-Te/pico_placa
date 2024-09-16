package com.jt.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.backend.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
