package net.skhu.lms.controller;

import java.util.List;

import net.skhu.lms.entity.Board;
import net.skhu.lms.service.BoardService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

	private BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/lecture/{id}/boards")
	public ResponseEntity<?> getBoards(@PathVariable int id) {
		List<Board> boards = boardService.findByLectureId(id);

		return ResponseEntity.status(HttpStatus.OK)
				.body(boards);
	}
}
