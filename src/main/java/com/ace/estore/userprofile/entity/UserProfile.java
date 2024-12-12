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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(nullable = false)
	private String firstName;
	private String lastName;
	@Column(unique = true, nullable = true)
	private String username;

	@Column(nullable = false)
	private String password;

	private String email;

	@Column(nullable = false)
	private String phone;

	private String imageURL;
	private String about;

	private Boolean enabled;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> roles;

	@PrePersist
	private void setcreatedDate() {
		this.createdDate = LocalDateTime.now();
		if (Objects.isNull(this.enabled))
			this.enabled = true;
		if (Objects.nonNull(this.roles))
			this.roles.stream().forEach(role -> role.setUser(this));
	}

	@PreUpdate
	private void setUpdatedDate() {
		this.updatedDate = LocalDateTime.now();
	}
}
