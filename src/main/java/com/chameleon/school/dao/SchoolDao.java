package com.chameleon.school.dao;

import java.util.List;
import java.util.UUID;

import com.chameleon.school.model.School;

public interface SchoolDao {

	int addSchool(School school);

	/*
	 * default int addSchool(School school) { return addSchool(UUID.randomUUID(),
	 * number); }
	 */

	School getSchoolById(UUID id);

	List<School> getAllSchools();

	int updateSchool(UUID id, School school);

	int deleteSchoolById(UUID id);

}
