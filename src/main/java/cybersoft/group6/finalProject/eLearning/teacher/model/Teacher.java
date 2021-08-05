package cybersoft.group6.finalProject.eLearning.teacher.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teacher")
@Getter
@Setter
public class Teacher extends AbstractEntity {

	@NotBlank
	private String description;
	@NotBlank
	private String experience;
	@NotBlank
	private Double rating;
}
