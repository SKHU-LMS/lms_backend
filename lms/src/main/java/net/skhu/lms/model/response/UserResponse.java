package net.skhu.lms.model.response;

import lombok.Builder;
import lombok.Getter;
import net.skhu.lms.entity.User;

@Getter
public class UserResponse {

	private Long id;
	private String userId;
	private String name;
	private String email;
	private String department;

	@Builder
	public UserResponse(Long id, String userId, String name, String email, String department) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.department = department;
	}
}
