package net.skhu.lms.controller;

import java.util.Comparator;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.skhu.lms.entity.Lecture;
import net.skhu.lms.entity.User;
import net.skhu.lms.model.request.LoginRequest;
import net.skhu.lms.model.response.UserLecturesResponse;
import net.skhu.lms.model.response.UserResponse;
import net.skhu.lms.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "사용자 로그인")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "학번", dataType = "String"),
			@ApiImplicitParam(name = "password", value = "비밀번호", dataType = "String")
	})
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
		User user = userService.login(loginRequest.getUserId(), loginRequest.getPassword());
		session.setAttribute("user", user);

		return ResponseEntity.status(HttpStatus.OK)
				.body(UserResponse.builder()
						.id(user.getId())
						.userId(user.getUserId())
						.name(user.getName())
						.email(user.getEmail())
						.department(user.getDepartment())
						.build()
				);
	}

	@GetMapping("/user")
	public ResponseEntity<?> getUserInfo(HttpSession session) {
		User u = (User) session.getAttribute("user");
		User user = userService.findByUserId(u.getUserId());

		return ResponseEntity.status(HttpStatus.OK)
				.body(UserResponse.builder()
						.id(user.getId())
						.userId(user.getUserId())
						.name(user.getName())
						.email(user.getEmail())
						.department(user.getDepartment())
						.build()
				);
	}

	@GetMapping("/{userId}/lectures")
	public ResponseEntity<?> getUserLectures(@PathVariable String userId) {
		User user = userService.findByUserId(userId);

		UserLecturesResponse userLecturesResponse = UserLecturesResponse.builder()
				.userId(user.getUserId())
				.userLectures(user.getUserLectures().stream()
						.sorted(Comparator.comparing(Lecture::getId))
						.collect(Collectors.toList()))
				.build();

		return ResponseEntity.status(HttpStatus.OK)
				.body(userLecturesResponse);
	}

}
