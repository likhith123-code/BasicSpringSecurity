package com.example.Security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Security.Model.User;

@Repository
public interface ApplicationRepository extends JpaRepository<User, Integer>{

	@Query(value = "select * from users where email = ?1",nativeQuery = true)
	User findbyEmail(String email);
	
}
