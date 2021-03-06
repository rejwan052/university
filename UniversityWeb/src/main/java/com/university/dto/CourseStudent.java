package com.university.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * CourseStudent DTO
 * 
 * @author aleksandar.kovachev
 *
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CourseStudent {

	private Long id;

	private Long courseId;

	private Long studentId;

	private Grade grade;

	private Account student;

}
