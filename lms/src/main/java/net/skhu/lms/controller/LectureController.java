package net.skhu.lms.controller;

import net.skhu.lms.entity.Lecture;
import net.skhu.lms.service.LectureService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LectureController {

	private final LectureService lectureService;

	public LectureController(LectureService lectureService) {
		this.lectureService = lectureService;
	}

	@GetMapping("/lecture/{id}")
	public ResponseEntity<?> getLecture(@PathVariable int id) {
		Lecture lecture = lectureService.findById(id);

		return ResponseEntity.status(HttpStatus.OK)
				.body(lecture);
	}

	@GetMapping("/lecture/{id}/users")
	public ResponseEntity<?> getLectureUsers(@PathVariable int id) {
		Lecture lecture = lectureService.findById(id);

		return ResponseEntity.status(HttpStatus.OK)
				.body(lecture.getUsers());
	}
}
