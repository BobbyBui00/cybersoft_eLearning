package cybersoft.group6.finalProject.eLearning.course.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "course_content")
@Getter
@Setter
public class CourseContent extends AbstractEntity {

	@NotBlank
	private String videoName;
	
	@NotBlank
	private String videoPath;
	
	@NotBlank
	private String videoDuration;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;
}
