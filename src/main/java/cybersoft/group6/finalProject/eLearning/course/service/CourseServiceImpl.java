package cybersoft.group6.finalProject.eLearning.course.service;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericServiceImpl;
import cybersoft.group6.finalProject.eLearning.course.model.Course;
import cybersoft.group6.finalProject.eLearning.course.repository.CourseRepository;

public class CourseServiceImpl extends GenericServiceImpl<Course, Long> implements CourseService {
	private CourseRepository courseRepository;
}
