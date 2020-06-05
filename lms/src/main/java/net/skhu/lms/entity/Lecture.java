package net.skhu.lms.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Lecture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String code;

	private int credit;

	private String name;

	private String professorName;

	private String metadata;

	private String divisionClass;

	@OneToMany
	@JoinColumn(name = "lecture_id")
	private List<Assignment> assignments = new ArrayList<>();
}