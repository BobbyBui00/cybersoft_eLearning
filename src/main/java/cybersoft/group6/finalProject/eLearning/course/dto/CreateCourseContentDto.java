package cybersoft.group6.finalProject.eLearning.course.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCourseContentDto {

	@NotBlank
	private String videoName;
	
	@NotBlank
	private String videoPath;
	
	@NotBlank
	private String videoDuration;
	
	
}
