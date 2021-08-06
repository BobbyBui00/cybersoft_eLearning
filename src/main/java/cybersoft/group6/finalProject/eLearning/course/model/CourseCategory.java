package cybersoft.group6.finalProject.eLearning.course.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "course_category")
@Getter
@Setter
public class CourseCategory extends AbstractEntity {

	@NotBlank
	private String courseCategoryId;
	
	@NotBlank
	private String courseCategoryName;
}
