package cybersoft.group6.finalProject.eLearning.course.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCourseDto {
	@NotBlank(message = "{course.courseName.not-blank}")
	private String courseName;
	
	@NotBlank(message = "{course.price.not-blank}")
	private double price;
	
	@NotBlank(message = "{course.description.not-blank}")
	private String description;
}
