package net.skhu.lms.service;

import net.skhu.lms.entity.Assignment;
import net.skhu.lms.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    private AssignmentRepository assignmentRepository;

    AssignmentService(AssignmentRepository assignmentRepository){
        this.assignmentRepository =  assignmentRepository;
    }

    public void test(){
        List<Assignment> list = assignmentRepository.findAll();
        for(Assignment a : list){
            System.out.println(a);
        }
    }
}
