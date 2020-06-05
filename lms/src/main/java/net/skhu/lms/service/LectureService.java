package net.skhu.lms.service;

import lombok.extern.slf4j.Slf4j;
import net.skhu.lms.entity.Lecture;
import net.skhu.lms.exceptioin.NotFoundException;
import net.skhu.lms.repository.LectureRepository;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LectureService {

	private LectureRepository lectureRepository;

	public LectureService(LectureRepository lectureRepository) {
		this.lectureRepository = lectureRepository;
	}

	public Lecture findById(int lectureId) {
		Lecture lecture = lectureRepository.findById(lectureId)
				.orElseThrow(() -> new NotFoundException("해당 강의를 찾을 수 없습니다. assignment id : " + lectureId));

		log.info(lecture.toString());

		return lecture;
	}
}