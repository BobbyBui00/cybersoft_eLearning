package cybersoft.group6.finalProject.eLearning.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import cybersoft.group6.finalProject.eLearning.course.model.Course;
import cybersoft.group6.finalProject.eLearning.payment.model.Payment;
import cybersoft.group6.finalProject.eLearning.user.utils.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends AbstractEntity {

	private String username;
	
	private String password;
	
	private String confirmPassword;
	
	private int exp;
	
	private Double rating;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "user_course_registered_list",
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courseList = new HashSet<>();
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "user_course_wish_list", 
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> wishList = new HashSet<>();
	
	private String gmail;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private Payment paymentInfo;
	private Set<Payment> paymentInfo = new HashSet<Payment>();
}
