package net.skhu.lms.service;

import lombok.extern.slf4j.Slf4j;
import net.skhu.lms.entity.Assignment;
import net.skhu.lms.exceptioin.NotFoundException;
import net.skhu.lms.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AssignmentService {

    private AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment findById(int assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new NotFoundException("해당 과제를 찾을 수 없습니다. assignment id : " + assignmentId));

        log.info(assignment.toString());

        return assignment;
    }
}
