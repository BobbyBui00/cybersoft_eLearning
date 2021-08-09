package cybersoft.group6.finalProject.eLearning.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.group6.finalProject.eLearning.course.model.CourseContent;

@Repository
public interface CourseContentRepository extends JpaRepository<CourseContent, Long> {

}
