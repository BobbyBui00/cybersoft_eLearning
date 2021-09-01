package cybersoft.group6.finalProject.eLearning.course.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;

import cybersoft.group6.finalProject.eLearning.commondata.model.ResponseHandler;
import cybersoft.group6.finalProject.eLearning.course.dto.CreateCourseDto;
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseDto;
import cybersoft.group6.finalProject.eLearning.course.model.Course;
import cybersoft.group6.finalProject.eLearning.course.service.CourseService;
import lombok.AllArgsConstructor;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/course")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllCourse(){
		//find course
		List<Course> courses = courseService.findAll();
		//check if the return is null
		if(courses.isEmpty()) {
			return ResponseHandler.getResponse("There is no data", HttpStatus.BAD_REQUEST);
		}
		
		return ResponseHandler.getResponse(courses, HttpStatus.OK);
	}
	
	@GetMapping("search/{course-name}")
	public ResponseEntity<Object> findCourseByCourseName(@PathVariable("course-name") String name)
	{
		List<Course> courses = courseService.findByCourseNameContaining(name);
		if(courses.isEmpty())
			return ResponseHandler.getResponse("There is no data",HttpStatus.OK );
		return ResponseHandler.getResponse(courses, HttpStatus.OK);
	}
	
	@GetMapping("/seach-course/{course-name}/{course-instructor}")
	public ResponseEntity<Object> findCourseByCourseNameAndCourseInstructor(@PathVariable("course-name") String courseName, @PathVariable("course-instructor") String courseInstructor) {
		
		Course course = courseService.searchCourseByNameAndInstructor(courseName, courseInstructor);
		
		if (course == null)
			return ResponseHandler.getResponse(HttpStatus.OK);
		
		return ResponseHandler.getResponse(course, HttpStatus.OK);
		
	}

	
	@GetMapping("/search-course-category/{course-category}")
	public ResponseEntity<Object> getAllCourseByCategory(@Valid @PathVariable("course-category") String category) {
		
		List<Course> listCourse = courseService.getCourseByCourseCategory(category);
		
		if(listCourse.isEmpty())
			return ResponseHandler.getResponse(HttpStatus.OK);
		
		return ResponseHandler.getResponse(listCourse, HttpStatus.OK);
	}
	
	@GetMapping("/{course-id}")
	public ResponseEntity<Object> findCourseById(@PathVariable("course-id") Long courseId)
	{
		Optional<Course> courses = courseService.findByCourseId(courseId);
		
		if(courses == null)
			return ResponseHandler.getResponse("There is no data",HttpStatus.OK );
		
		return ResponseHandler.getResponse(courses, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addNewCourse(@Valid 
												@RequestBody CreateCourseDto dto,
												BindingResult result){
		if(result.hasErrors())
			return ResponseHandler.getResponse("There is an error", HttpStatus.BAD_REQUEST);
		
		Course newCourse = courseService.addNewCourse(dto);
		
		return ResponseHandler.getResponse(newCourse, HttpStatus.OK);
	}
	
	@PutMapping("/{course-id}")
	public ResponseEntity<Object> updateCourse(@Valid
												@RequestBody
												UpdateCourseDto dto,
												BindingResult result,
												@PathVariable("course-id") Long courseId){
		if(courseId == null)
			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
		else if(result.hasErrors())
			return ResponseHandler.getResponse("There is an error", HttpStatus.BAD_REQUEST);
		Course updatedCourse = courseService.updateCourse(dto, courseId);
		
		return ResponseHandler.getResponse(updatedCourse, HttpStatus.OK);
	}
	
	@DeleteMapping("/{course-id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable("course-id") Long courseId){
		
		if(courseId == null)
			return ResponseHandler.getResponse("Cannot delete course", HttpStatus.BAD_REQUEST);
		
		courseService.deleteById(courseId);
		return ResponseHandler.getResponse("Delete success" + courseId, HttpStatus.OK);
	}
}