package cybersoft.group6.finalProject.eLearning.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import cybersoft.group6.finalProject.eLearning.course.model.Course;
import cybersoft.group6.finalProject.eLearning.payment.model.Payment;
import cybersoft.group6.finalProject.eLearning.user.utils.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "elearning_user")
@Getter
@Setter
public class User extends AbstractEntity {

	@NotBlank(message = "{user.username.not-blank}}")
	@Size(min = 3, max = 100, message = "{user.username.size}")
	private String username;
	
	@NotBlank(message = "{user.password.not-blank")
	private String password;
	
	@NotBlank(message = "{user.confirmPassword.not-blank}")
	private String confirmPassword;
	
	private String exp;
	
	private Double rating;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "user_course_registered_list",
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "course_id"))
	@JsonIgnore
	private Set<Course> courseList = new HashSet<>();
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "user_course_wish_list", 
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "course_id"))
	@JsonIgnore
	private Set<Course> wishList = new HashSet<>();
	
	@NotBlank(message = "{user.gmail.not-blank}")
	private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Payment> paymentInfo = new HashSet<Payment>();
	
	@OneToMany(mappedBy = "courseInstructor", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Course> instructors = new HashSet<>();
	
	// Helper method
	
	public User username(String username) {
		this.username = username;
		return this;
	}
	
	public User password(String password) {
		this.password = password;
		return this;
	}
	
	public User confirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return this;
	}
	
	public User email(String email) {
		this.email = email;
		return this;
	}
	
	public User exp(String exp) {
		this.exp = exp;
		return this;
	}
	
	public User role(UserRole role) {
		this.role = role;
		return this;
	}
	
	
} 
