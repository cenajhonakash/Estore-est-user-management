package com.ace.estore.userprofile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ace.estore.userprofile.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	public Optional<UserProfile> findByUsername(String username);

	public Optional<UserProfile> findByUsernameAndPassword(String username, String password);
}
