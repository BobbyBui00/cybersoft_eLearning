package cybersoft.group6.finalProject.eLearning.course.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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
	
	private Set<CourseContent> courseContent = new HashSet<>();
	
	private Set<CourseCategory> courseCategory = new HashSet<>();
	
	private int learnerNumber;
	
	@ManyToMany(mappedBy = "course_list", fetch = FetchType.LAZY)
	private Set<User> registedUser = new HashSet<>();
	
	@ManyToMany(mappedBy = "wish_list", fetch = FetchType.LAZY)
	private Set<User> userWishList = new HashSet<>();
	
	
}
