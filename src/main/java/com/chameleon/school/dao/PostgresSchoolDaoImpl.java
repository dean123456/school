package com.chameleon.school.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chameleon.school.model.School;

@Repository("postgres")
public class PostgresSchoolDaoImpl implements SchoolDao {
	
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public PostgresSchoolDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addSchool(School school) {
		String sql = "insert into school(id, number) values(?, ?);";
		return jdbcTemplate.update(sql, UUID.randomUUID(), school.getNumber());
	}

	@Override
	public School getSchoolById(UUID id) {
		String sql = "select id, number from school where id = ?";
		School school = jdbcTemplate.queryForObject(sql, new Object[] {id}, (resultSet, i) -> {
			UUID schoolId = UUID.fromString(resultSet.getString("id"));
			int number = resultSet.getInt("number");
			return new School(schoolId, number);
		});
		return school;
	}

	@Override
	public List<School> getAllSchools() {
		String sql = "select id, number from school";
		return jdbcTemplate.query(sql, (resultSet, i) ->{
			UUID schoolId = UUID.fromString(resultSet.getString("id"));
			int number = resultSet.getInt("number");
			return new School(schoolId, number);
		});
	}

	@Override
	public int updateSchool(UUID id, School school) {
		String sql = "update school set number = ? where id = ?";
		return jdbcTemplate.update(sql, school.getNumber(), id);
	}

	@Override
	public int deleteSchoolById(UUID id) {
		String sql = "delete from school where id = ?";
		return jdbcTemplate.update(sql, id);
	}

}
