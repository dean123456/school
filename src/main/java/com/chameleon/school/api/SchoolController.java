package com.chameleon.school.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chameleon.school.model.School;
import com.chameleon.school.service.SchoolService;

@RequestMapping("school")
@RestController
public class SchoolController {
	
	private SchoolService schoolService;
	
	@Autowired
	public SchoolController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	
	@PostMapping
	public int addSchool(@RequestBody School school) {
		return schoolService.addSchool(school);
	}
	
	@GetMapping(path = "{id}")
	public School getSchool(@PathVariable("id") UUID id) {
		return schoolService.getSchool(id);
	}
	
	@GetMapping
	public List<School> getSchools(){
		return schoolService.getSchools();
	}
	
	@DeleteMapping(path = "{id}")
	public int deleteSchool(@PathVariable("id") UUID id) {
		return schoolService.deleteSchool(id);
	}
	
	@PutMapping(path = "{id}")
	public int updateSchool(@PathVariable("id") UUID id, @RequestBody School school) {
		return schoolService.updateSchool(id, school);
	}

}
