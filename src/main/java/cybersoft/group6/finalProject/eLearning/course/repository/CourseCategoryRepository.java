package cybersoft.group6.finalProject.eLearning.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.group6.finalProject.eLearning.course.model.CourseCategory;

@Repository
public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Long> {
	CourseCategory findByCourseCategoryName(String courseCategoryName);
}
