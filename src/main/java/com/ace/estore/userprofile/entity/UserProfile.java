package com.ace.estore.userprofile.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_profile")
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long userId;

	@Column(nullable = false)
	private String firstName;
	private String lastName;
	@Column(unique = true, nullable = false)
	private String password;
	private String email;
	@Column(unique = true, nullable = false)
	private String phone;
	private String imageURL;
	private String about;

	private String gender;

	private LocalDateTime createdDate;

	private Boolean enabled;

	/*
	 * Roles: CUSTOMER(CUS), STORE ASSOCIATE(SAS), STORE ADMIN(SAD), STORE
	 * MANAGER(SMA)
	 */
	@OneToMany(targetEntity = UserRole.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "user_id") })
	private Set<UserRole> roles;

	@PrePersist
	private void setUpdatedDate() {
		this.createdDate = LocalDateTime.now();
		if (Objects.isNull(this.enabled))
			this.enabled = true;
	}
}
