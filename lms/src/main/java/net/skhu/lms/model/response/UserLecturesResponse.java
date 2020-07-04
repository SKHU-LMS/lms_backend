package net.skhu.lms.model.response;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import net.skhu.lms.entity.Lecture;

@Getter
public class UserLecturesResponse {

	private String userId;

	private List<Lecture> userLectures;

	@Builder
	public UserLecturesResponse(String userId, List<Lecture> userLectures) {
		this.userId = userId;
		this.userLectures = userLectures;
	}
}
