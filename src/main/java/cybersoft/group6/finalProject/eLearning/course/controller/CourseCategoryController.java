package cybersoft.group6.finalProject.eLearning.course.controller;

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
import cybersoft.group6.finalProject.eLearning.course.dto.CreateCourseCategoryDto;
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseCategoryDto;
import cybersoft.group6.finalProject.eLearning.course.model.Course;
import cybersoft.group6.finalProject.eLearning.course.model.CourseCategory;
import cybersoft.group6.finalProject.eLearning.course.service.CourseCategoryService;

@RestController
@RequestMapping("/api/course/category")
public class CourseCategoryController {

	@Autowired
	private CourseCategoryService service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllCourseCategory()
	{
		List<CourseCategory> categories=service.findAll();
		
		if(categories.isEmpty())
		{
			return ResponseHandler.getResponse("There is no data", HttpStatus.OK);
			
		}
		return ResponseHandler.getResponse(categories, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addNewCourseCategory(@Valid @RequestBody CreateCourseCategoryDto dto,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		CourseCategory courseCategory=service.addNewCourseCategory(dto);
			return ResponseHandler.getResponse(courseCategory, HttpStatus.OK);
	}
	
	@PutMapping("/{courseCategory-id}")
	public ResponseEntity<Object> updateCourseCategory(@Valid @RequestBody UpdateCourseCategoryDto dto,@PathVariable ("courseCategory-id") Long courseCategoryId,BindingResult bindingResult)
	{
		if(courseCategoryId == null)
			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
		
		else if(bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		CourseCategory courseCategory=service.updateCourseCategory(dto, courseCategoryId);
			return ResponseHandler.getResponse(courseCategory, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{courseCategory-id}")
	public ResponseEntity<Object> deleteCourseCategory(@PathVariable ("courseCategory-id") Long id)
	{
		if(id == null)
			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
		
		service.deleteById(id);
		return ResponseHandler.getResponse("Deleted ID "+ id, HttpStatus.OK);
	}
}
