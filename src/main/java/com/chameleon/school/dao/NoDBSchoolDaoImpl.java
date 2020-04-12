package com.chameleon.school.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.chameleon.school.model.School;

@Repository("NoDB")
public class NoDBSchoolDaoImpl implements SchoolDao {

	public static List<School> DB = new ArrayList<>();

	@Override
	public int addSchool(School school) {
		DB.add(school);
		return 1;
	}

	@Override
	public School getSchoolById(UUID id) {
		Optional<School> school = DB.stream().filter(s -> s.getId().equals(id)).findFirst();
		return school.orElse(null);
	}

	@Override
	public List<School> getAllSchools() {
		return DB;
	}

	@Override
	public int updateSchool(UUID id, School school) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSchoolById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
