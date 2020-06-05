package net.skhu.lms.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
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
    @JoinColumn(name="assignment_id")
    private List<UserAssignment> userAssignments  = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="assignment_id")
    private List<AssignmentFile> assignmentFiles  = new ArrayList<>();
}
