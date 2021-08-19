package cybersoft.group6.finalProject.eLearning.course.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCourseCategoryDto {

	@NotBlank(message = "{course.category.courseCategoryId.not-blank}")
	private String courseCategoryId;
	
	@NotBlank(message = "{course.category.courseCategoryName.not-blank}")
	private String courseCategoryName;
}
