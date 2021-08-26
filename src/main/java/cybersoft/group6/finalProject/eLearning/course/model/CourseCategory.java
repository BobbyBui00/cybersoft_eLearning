package cybersoft.group6.finalProject.eLearning.course.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "elearning_course_category")
@Getter
@Setter
public class CourseCategory extends AbstractEntity {

	@NotBlank
	private String courseCategoryId;
	
	@NotBlank
	private String courseCategoryName;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "course_course_category",
				joinColumns = @JoinColumn(name = "course_category_id"),
				inverseJoinColumns = @JoinColumn(name = "course_id"))
	@JsonIgnore
	private Set<Course> course = new HashSet<Course>();
	
}
