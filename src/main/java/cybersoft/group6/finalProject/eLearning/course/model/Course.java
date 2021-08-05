package cybersoft.group6.finalProject.eLearning.course.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import cybersoft.group6.finalProject.eLearning.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "course")
@Getter
@Setter
public class Course extends AbstractEntity {
	@NotBlank
	private String courseName;
	
	private String courseDescription;
	
	private double duration;
	
	private User courseInstructor;
	
	@NotBlank
	private float rating;
	
	@NotBlank
	private double price;
	
	private String avatar;
	
	private List<CourseContent> courseContent;
	
	private List<CourseCategory> courseCategory;
	
	private int learnerNumber;
	
}
