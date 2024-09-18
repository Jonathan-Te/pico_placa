package com.jt.backend.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.backend.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
	List<User> findUserByEmailAndPassw(String email, String passw);
}
