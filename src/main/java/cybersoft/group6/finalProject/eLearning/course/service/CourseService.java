package cybersoft.group6.finalProject.eLearning.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericService;
import cybersoft.group6.finalProject.eLearning.course.dto.CreateCourseDto;
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseDto;
import cybersoft.group6.finalProject.eLearning.course.model.Course;

public interface CourseService extends GenericService<Course, Long> {
	Course addNewCourse(CreateCourseDto dto);
	
	Course updateCourse(UpdateCourseDto dto, Long courseId);
	
	public List<Course> findCourses(String courseName);
	
	public List<Course> findByCourseNameContaining(String courseName);

	Optional<Course> findByCourseId(Long courseId);

	List<Course> findAllInformationAboutCourse();
	
	List<Course> getCourseByCourseCategory(String category);
	
	Course searchCourseByNameAndInstructor(String courseName, String courseInstructor);
	
}
