package com.cooksys.ftd.SpringSocialMediaAssessment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.ftd.SpringSocialMediaAssessment.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserCredentialsUsername(String username);

	User findUserByUserCredentialsUsername(String username);

}