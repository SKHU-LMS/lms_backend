package net.skhu.lms.repository;

import net.skhu.lms.entity.Board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
