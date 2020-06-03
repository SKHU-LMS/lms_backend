package net.skhu.lms.controller;

import net.skhu.lms.entity.Assignment;
import net.skhu.lms.service.AssignmentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {

    private AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<?> getAssignment(@PathVariable int id) {
        Assignment assignment = assignmentService.findById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(assignment);
    }
}