package cybersoft.group6.finalProject.eLearning.course.service;

import org.springframework.stereotype.Service;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericService;
import cybersoft.group6.finalProject.eLearning.course.dto.CreateCourseDto;
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseDto;
import cybersoft.group6.finalProject.eLearning.course.model.Course;

public interface CourseService extends GenericService<Course, Long> {
	Course addNewCourse(CreateCourseDto dto);
	
	Course updateCourse(UpdateCourseDto dto, Long courseId);
}
