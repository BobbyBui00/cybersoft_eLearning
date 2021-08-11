package cybersoft.group6.finalProject.eLearning.course.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;

import cybersoft.group6.finalProject.eLearning.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "elearnig_course")
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
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Set<CourseContent> courseContent = new HashSet<>();
	
	@ManyToMany(mappedBy = "course")
	private Set<CourseCategory> courseCategory = new HashSet<>();
	
	private int learnerNumber;
	
	@ManyToMany(mappedBy = "courseList", fetch = FetchType.LAZY)
	private Set<User> registedUser = new HashSet<>();
	
	@ManyToMany(mappedBy = "wishList", fetch = FetchType.LAZY)
	private Set<User> userWishList = new HashSet<>();
	

	
}
