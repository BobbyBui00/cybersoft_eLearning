package cybersoft.group6.finalProject.eLearning.course.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericServiceImpl;
import cybersoft.group6.finalProject.eLearning.course.dto.CreateCourseContentDto;
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseContentDto;
import cybersoft.group6.finalProject.eLearning.course.model.CourseContent;
import cybersoft.group6.finalProject.eLearning.course.repository.CourseContentRepository;
import cybersoft.group6.finalProject.eLearning.util.MapDtoToModel;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CourceContentServiceImpl extends GenericServiceImpl<CourseContent, Long> implements CourseContentService {
	
	@Autowired
	private CourseContentRepository repository;
	
	private MapDtoToModel<Object, CourseContent> mapper;
	
	private ModelMapper modelMapper;
	
	@Override
	public CourseContent updateCourseContentInfo(UpdateCourseContentDto dto, Long courseContentId) {
		// TODO Auto-generated method stub
	CourseContent content =repository.getById(courseContentId);
	modelMapper.map(dto, content);
		
		return repository.save(content);
	}

	

}
