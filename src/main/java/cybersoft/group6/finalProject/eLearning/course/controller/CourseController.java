package cybersoft.group6.finalProject.eLearning.course.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.group6.finalProject.eLearning.commondata.model.ResponseHandler;
import cybersoft.group6.finalProject.eLearning.course.dto.CreateCourseDto;
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseDto;
import cybersoft.group6.finalProject.eLearning.course.model.Course;
import cybersoft.group6.finalProject.eLearning.course.service.CourseService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/course")
@AllArgsConstructor
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
	
	@PostMapping("")
	public ResponseEntity<Object> addNewCourse(@Valid 
												@RequestBody 
												CreateCourseDto dto,
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