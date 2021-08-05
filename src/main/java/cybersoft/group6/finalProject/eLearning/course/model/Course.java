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
	@NotBlank(message = "{course.courseName.not-blank}")
	private String courseName;
	
	private String courseDescription;
	
	@NotBlank(message = "{course.duration.not-blank}")
	private double duration;
	
	@NotBlank(message = "{course.courseInstructor.not-blank}")
	private User courseInstructor;
	
	@NotBlank(message = "{course.rating.not-blank}")
	private float rating;
	
	@NotBlank (message ="{course.price.not-blank}")
	private double price;
	
	private String avatar;
	
	private List<CourseContent> courseContent;
	
	private List<CourseCategory> courseCategory;
	
	private int learnerNumber;
	
}
