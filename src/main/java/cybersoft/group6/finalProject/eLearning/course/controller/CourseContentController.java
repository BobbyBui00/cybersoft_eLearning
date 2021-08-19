package cybersoft.group6.finalProject.eLearning.course.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseContentDto;
import cybersoft.group6.finalProject.eLearning.course.model.CourseContent;
import cybersoft.group6.finalProject.eLearning.course.service.CourseContentService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/course/content")
@AllArgsConstructor
public class CourseContentController {

	private CourseContentService service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllCourseContent(){
		List<CourseContent> courseContent=service.findAll();
		
		if(courseContent.isEmpty())
			return ResponseHandler.getResponse("There is no data", HttpStatus.OK);
		
		return ResponseHandler.getResponse(courseContent, HttpStatus.OK);
	}
	
	@GetMapping("/{courseContent-id}")
	public ResponseEntity<Object> findById(@PathVariable ("courseContent-id") Long id)
	{
		Optional<CourseContent> courseContents=service.findById(id);
		if(courseContents.isEmpty())
			return ResponseHandler.getResponse("There no data id ", HttpStatus.BAD_REQUEST);
		
		return ResponseHandler.getResponse(courseContents, HttpStatus.OK);
			
	}
	
	
	@PostMapping("")
	public ResponseEntity<Object> addNewCourseContent(@Valid @RequestBody CourseContent courseContent, BindingResult bindingResult )
	{
		if(bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		CourseContent addCourseContent=service.save(courseContent);
		return ResponseHandler.getResponse(addCourseContent, HttpStatus.OK);
	}
	
	@PutMapping("/{courseContent-id}")
	public ResponseEntity<Object> updateCourseContent(@Valid @RequestBody UpdateCourseContentDto dto, @PathVariable ("courseContent-id") Long courseContentId,BindingResult bindingResult)
	{
		if(courseContentId == null)
			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
		
		if(bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		CourseContent courseContent=service.updateCourseContentInfo(dto, courseContentId);
		return ResponseHandler.getResponse(courseContent, HttpStatus.OK);
			
	}
	
	@DeleteMapping("/{courseContent-id}")
	public ResponseEntity<Object> deleteCourseConten(@PathVariable ("courseContent-id") Long courseContentId)
	{
		if(courseContentId == null)
			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
		
		service.deleteById(courseContentId);
		return ResponseHandler.getResponse("Delete CourseContentId" + courseContentId, HttpStatus.OK);
	}
	
}
