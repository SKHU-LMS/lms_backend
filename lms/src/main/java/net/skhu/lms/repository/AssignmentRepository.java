package net.skhu.lms.repository;

import net.skhu.lms.entity.Assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
}
