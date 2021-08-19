package cybersoft.group6.finalProject.eLearning.course.service;

import javax.validation.Valid;

import cybersoft.group6.finalProject.eLearning.commonData1.GenericService;
import cybersoft.group6.finalProject.eLearning.course.dto.CreateCourseContentDto;
import cybersoft.group6.finalProject.eLearning.course.dto.UpdateCourseContentDto;
import cybersoft.group6.finalProject.eLearning.course.model.CourseContent;

public interface CourseContentService extends GenericService<CourseContent, Long> {

	CourseContent updateCourseContentInfo(UpdateCourseContentDto dto,Long courseContentId);
}
