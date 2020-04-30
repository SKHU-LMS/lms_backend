package net.skhu.lms.service;

import java.util.Optional;

import io.swagger.annotations.ApiOperation;
import net.skhu.lms.entity.User;
import net.skhu.lms.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User login(String userId, String password) {
		User user = userRepository.findByUserId(userId).orElseThrow(() ->
				new RuntimeException("User ID: " + userId + "에 해당하는 사용자가 존재하지 않습니다."));

		if (!BCrypt.checkpw(password, user.getPassword())) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}

		return user;
	}
}
