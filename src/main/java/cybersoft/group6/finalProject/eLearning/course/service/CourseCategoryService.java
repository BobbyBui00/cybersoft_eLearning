package cybersoft.group6.finalProject.eLearning.course.service;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericService;
import cybersoft.group6.finalProject.eLearning.course.dto.CreateCourseCategoryDto;
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseCategoryDto;
import cybersoft.group6.finalProject.eLearning.course.model.CourseCategory;

public interface CourseCategoryService extends GenericService<CourseCategory, Long> {

	CourseCategory addNewCourseCategory(CreateCourseCategoryDto dto);
	
	CourseCategory updateCourseCategory(UpdateCourseCategoryDto dto,Long courseCategoryId);
	

}
