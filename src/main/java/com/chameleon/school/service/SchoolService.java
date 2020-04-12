package com.chameleon.school.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chameleon.school.dao.SchoolDao;
import com.chameleon.school.model.School;

@Service
public class SchoolService {
	
	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolService(@Qualifier("postgres")SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}
	
	public int addSchool(School school) {
		return schoolDao.addSchool(school);
	}
	
	public School getSchool(UUID id) {
		return schoolDao.getSchoolById(id);
	}
	
	public List<School> getSchools(){
		return schoolDao.getAllSchools();
	}
	
	public int deleteSchool(UUID id) {
		return schoolDao.deleteSchoolById(id);
	}
	
	public int updateSchool(UUID id, School school) {
		return schoolDao.updateSchool(id, school);
	}

}
