package cybersoft.group6.finalProject.eLearning.user.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import cybersoft.group6.finalProject.eLearning.course.model.Course;
import cybersoft.group6.finalProject.eLearning.payment.model.Payment;
import cybersoft.group6.finalProject.eLearning.role.model.Role;
import cybersoft.group6.finalProject.eLearning.teacher.model.Teacher;
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
	
	private List<Course> courseList;
	
	private List<Course> wishList;
	
	private String gmail;
	
	private Payment paymentInfo;
	
	private Role role;
	
	private String userId;
	
	private Teacher teacher;
}
