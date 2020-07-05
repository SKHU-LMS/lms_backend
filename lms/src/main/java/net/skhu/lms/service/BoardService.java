package net.skhu.lms.service;

import java.util.List;

import net.skhu.lms.entity.Board;
import net.skhu.lms.entity.Lecture;
import net.skhu.lms.exceptioin.NotFoundException;
import net.skhu.lms.repository.BoardRepository;
import net.skhu.lms.repository.LectureRepository;

import org.springframework.stereotype.Service;

@Service
public class BoardService {

	private BoardRepository boardRepository;

	private LectureRepository lectureRepository;

	public BoardService(BoardRepository boardRepository, LectureRepository lectureRepository) {
		this.boardRepository = boardRepository;
		this.lectureRepository = lectureRepository;
	}

	public List<Board> findByLectureId(int lectureId) {
		Lecture lecture = lectureRepository.findById(lectureId)
				.orElseThrow(() -> new NotFoundException("해당 강의를 찾을 수 없습니다. assignment id : " + lectureId));
		List<Board> boards = lecture.getBoards();

		return boards;
	}
}
