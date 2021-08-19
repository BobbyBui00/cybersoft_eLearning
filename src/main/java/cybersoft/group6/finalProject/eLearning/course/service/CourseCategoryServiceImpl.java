package cybersoft.group6.finalProject.eLearning.course.service;

import org.springframework.stereotype.Service;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericServiceImpl;
import cybersoft.group6.finalProject.eLearning.course.dto.CreateCourseCategoryDto;
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseCategoryDto;
import cybersoft.group6.finalProject.eLearning.course.model.CourseCategory;
import cybersoft.group6.finalProject.eLearning.course.repository.CourseCategoryRepository;
import cybersoft.group6.finalProject.eLearning.util.MapDtoToModel;
import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class CourseCategoryServiceImpl extends GenericServiceImpl<CourseCategory, Long> implements CourseCategoryService {


	private CourseCategoryRepository repository;
	
	private MapDtoToModel<Object, CourseCategory> mapper;
	
	@Override
	public CourseCategory addNewCourseCategory(CreateCourseCategoryDto dto) {
		// TODO Auto-generated method stub
		CourseCategory courseCategory=new CourseCategory();
		courseCategory = mapper.map(dto, courseCategory);
				
		return repository.save(courseCategory);
	}

	@Override
	public CourseCategory updateCourseCategory(UpdateCourseCategoryDto dto, Long courseCategoryId) {
		// TODO Auto-generated method stub
		CourseCategory courseCategory=repository.getById(courseCategoryId);
		courseCategory = mapper.map(dto,courseCategory);
		return repository.save(courseCategory);
	}

}
