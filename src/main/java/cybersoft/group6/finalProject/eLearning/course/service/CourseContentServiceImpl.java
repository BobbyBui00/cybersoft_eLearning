package cybersoft.group6.finalProject.eLearning.course.service;

import org.springframework.stereotype.Service;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericServiceImpl;
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseContentDto;
import cybersoft.group6.finalProject.eLearning.course.model.CourseContent;
import cybersoft.group6.finalProject.eLearning.course.repository.CourseContentRepository;
import cybersoft.group6.finalProject.eLearning.util.MapDtoToModel;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CourseContentServiceImpl extends GenericServiceImpl<CourseContent, Long> implements CourseContentService {
	
	private CourseContentRepository repository;
	
	private MapDtoToModel<Object, CourseContent> mapper;
	
	@Override
	public CourseContent updateCourseContentInfo(UpdateCourseContentDto dto, Long courseContentId) {
		// TODO Auto-generated method stub
		CourseContent content = repository.getById(courseContentId);
		content = mapper.map(dto, content);
		
		return repository.save(content);
	}

	

}
