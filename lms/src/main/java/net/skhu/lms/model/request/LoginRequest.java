package net.skhu.lms.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginRequest {

	private String userId;
	private String password;

	public LoginRequest(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
}
