package net.skhu.lms.entity;

import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true, updatable = false, nullable = false)
	private String userId;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String phoneNumber;

	@Column(nullable = false)
	private String department;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@ManyToMany
	@JsonIgnore
	@JoinTable(
			name = "user_lecture",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "lecture_id")
	)
	private Set<Lecture> userLectures;
}
