package net.skhu.lms.repository;

import net.skhu.lms.entity.Lecture;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {
}