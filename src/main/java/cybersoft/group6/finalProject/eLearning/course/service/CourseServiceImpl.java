package cybersoft.group6.finalProject.eLearning.course.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cybersoft.group6.finalProject.eLearning.commonData1.GenericServiceImpl;
import cybersoft.group6.finalProject.eLearning.course.dto.CreateCourseDto;
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseDto;
import cybersoft.group6.finalProject.eLearning.course.model.Course;
import cybersoft.group6.finalProject.eLearning.course.model.CourseCategory;
import cybersoft.group6.finalProject.eLearning.course.repository.CourseCategoryRepository;
import cybersoft.group6.finalProject.eLearning.course.repository.CourseRepository;
import cybersoft.group6.finalProject.eLearning.user.model.User;
import cybersoft.group6.finalProject.eLearning.user.repository.UserRepository;
import cybersoft.group6.finalProject.eLearning.util.MapDtoToModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl extends GenericServiceImpl<Course, Long> implements CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private CourseCategoryRepository courseCategoryRepository;
	
	private ModelMapper model;
	private MapDtoToModel<Object, Course> mapper;

	@Override
	public Course addNewCourse(CreateCourseDto dto) {
		// TODO Auto-generated method stub
		Course course = new Course();
		course = mapper.map(dto, course);
		
		//only find the attribute, not the relationship
		// Use Optional only when they require or suggest
		User instructors = userRepository.findByUsername(dto.getCourseInstructor());
		course.setCourseInstructor(instructors);
		
		CourseCategory courseCategory = courseCategoryRepository.findByCourseCategoryName(dto.getCourseCategory());
		course.setCourseCategory(courseCategory);
		
		course.setDuration(dto.getDuration());
		course.setPrice(dto.getPrice());
		course.setRating(dto.getRating());
		return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(UpdateCourseDto dto, Long courseId) {
		// TODO Auto-generated method stub
		
		Course updatedCourse = courseRepository.getById(courseId);
		model.map(dto, updatedCourse);
		
		return courseRepository.save(updatedCourse);
	}

	@Override
	public List<Course> findCourses(String courseName) {
		// TODO Auto-generated method stub
		
		return courseRepository.findCourses(courseName);
	}

	@Override
	public List<Course> findByCourseNameContaining(String courseName) {
		// TODO Auto-generated method stub
		return courseRepository.findByCourseNameContaining(courseName);
	}

	@Override
	public Optional<Course> findByCourseId(Long courseId) {
		// TODO Auto-generated method stub
		return courseRepository.findById(courseId);
	}

	@Override
	public List<Course> findAllInformationAboutCourse() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	
	
}
