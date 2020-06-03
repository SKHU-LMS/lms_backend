package net.skhu.lms.controller;

import java.util.List;

import net.skhu.lms.entity.Assignment;
import net.skhu.lms.entity.Lecture;
import net.skhu.lms.service.AssignmentService;
import net.skhu.lms.service.LectureService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {

    private AssignmentService assignmentService;

    private LectureService lectureService;

    public AssignmentController(AssignmentService assignmentService, LectureService lectureService) {
        this.assignmentService = assignmentService;
        this.lectureService = lectureService;
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<?> getAssignment(@PathVariable int id) {
        Assignment assignment = assignmentService.findById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(assignment);
    }

    @GetMapping("lecture/{id}/assignments")
    public ResponseEntity<?> getAssignmentList(@PathVariable int id) {
        Lecture lecture = lectureService.findById(id);
        List<Assignment> assignmentList = lecture.getAssignments();

        return ResponseEntity.status(HttpStatus.OK)
                .body(assignmentList);
    }
}