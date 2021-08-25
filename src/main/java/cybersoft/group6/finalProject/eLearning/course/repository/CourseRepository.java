package cybersoft.group6.finalProject.eLearning.course.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Repository;

import cybersoft.group6.finalProject.eLearning.course.model.Course;
import cybersoft.group6.finalProject.eLearning.course.model.CourseCategory;
import cybersoft.group6.finalProject.eLearning.user.model.User;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	@Query("SELECT e FROM Course e WHERE e.courseName = ?1")
	public List<Course> findCourses(String courseName);
	
	public List<Course> findByCourseNameContaining(String courseName);

	public List<Course> findByCourseIdContaining(int courseId);
}
