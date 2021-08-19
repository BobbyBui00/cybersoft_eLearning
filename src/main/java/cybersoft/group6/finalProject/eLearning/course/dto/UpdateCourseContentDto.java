package cybersoft.group6.finalProject.eLearning.course.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCourseContentDto {
	@NotBlank(message = "{courseContent.videoname.not-blank}")
	private String videoName;
	
	@NotBlank(message = "{courseContent.videoPath.not-blank}")
	private String videoPath;
	
	@NotBlank(message = "{courseContent.videoDuration.not-blank}")
	private String videoDuration;
	
	private int numberVideo;

	
}
