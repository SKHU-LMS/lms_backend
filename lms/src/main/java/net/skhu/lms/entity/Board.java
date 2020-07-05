package net.skhu.lms.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.CreatedDate;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String content;

	@CreatedDate
	@Column(updatable = false, nullable = false)
	private LocalDateTime createDate;
}
