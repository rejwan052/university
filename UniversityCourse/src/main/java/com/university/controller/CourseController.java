package com.university.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.university.constant.RequestConstant;
import com.university.constant.ResponseStatus;
import com.university.entity.Course;
import com.university.filter.CourseFilter;
import com.university.response.CourseResponse;
import com.university.service.CourseService;

/**
 * Rest controller for working with courses
 * 
 * @author aleksandar.kovachev
 *
 */
@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping(RequestConstant.COURSE_GET)
	public CourseResponse getCourses(@ModelAttribute CourseFilter filter) {
		CourseResponse response = new CourseResponse();
		response.setTotalCount(courseService.getCountCoursesByFilter(filter));
		response.setCourses(courseService.getCoursesByFilter(filter));
		response.setStatus(ResponseStatus.SUCCESSFUL.getStatus());
		return response;
	}

	@GetMapping(RequestConstant.COURSE)
	public Course course(@PathVariable("id") String id) {
		if (!StringUtils.isNumeric(id)) {
			return null;
		}
		return courseService.getCourse(Long.parseLong(id));
	}

}