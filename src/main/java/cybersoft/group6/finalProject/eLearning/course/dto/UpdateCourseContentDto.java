package cybersoft.group6.finalProject.eLearning.course.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


public class UpdateCourseContentDto {
	@NotBlank(message = "{courseContent.videoname.not-blank}")
	private String videoName;
	
	@NotBlank(message = "{courseContent.videoPath.not-blank}")
	private String videoPath;
	
	@NotBlank(message = "{courseContent.videoDuration.not-blank}")
	private String videoDuration;
	
	
	private int numberVideo;


	public String getVideoName() {
		return videoName;
	}


	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}


	public String getVideoPath() {
		return videoPath;
	}


	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}


	public String getVideoDuration() {
		return videoDuration;
	}


	public void setVideoDuration(String videoDuration) {
		this.videoDuration = videoDuration;
	}


	public int getNumberVideo() {
		return numberVideo;
	}


	public void setNumberVideo(int numberVideo) {
		this.numberVideo = numberVideo;
	}
	
	
}
