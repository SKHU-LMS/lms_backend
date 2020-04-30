package net.skhu.lms.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime updateDate;

    @Column(nullable = false)
    private LocalDateTime dueDate;

    private String score;

    @OneToMany

    private List<UserAssignment> userAssignments  = new ArrayList<>();

    @OneToMany
    private List<AssignmentFile> assignmentFiles  = new ArrayList<>();
}
