package cybersoft.group6.finalProject.eLearning.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cybersoft.group6.finalProject.eLearning.course.model.Course;
import cybersoft.group6.finalProject.eLearning.course.model.CourseCategory;

public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByCourseCategory(CourseCategory category);
	
	List<Course> findByCourseName(String name);
}
