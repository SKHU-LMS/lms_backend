package net.skhu.lms.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> exceptionHandler(RuntimeException exception) {
		log.error(exception.getMessage(), exception);
		String message = "서버 오류";

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(message);
	}
}
