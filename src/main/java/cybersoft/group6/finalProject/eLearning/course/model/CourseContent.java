package cybersoft.group6.finalProject.eLearning.course.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "elearning_course_content")
@Getter
@Setter
public class CourseContent extends AbstractEntity {

	@NotBlank(message = "{courseContent.videoname.not-blank}")
	private String videoName;
	
	@NotBlank(message = "{courseContent.videoPath.not-blank}")
	private String videoPath;
	
	@NotBlank(message = "{courseContent.videoDuration.not-blank}")
	private String videoDuration;
	
	private int numberVideo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Course course;
	
	public CourseContent videoName(String videoName)
	{
		this.videoName=videoName;
		return this;
	}
	
	
}
