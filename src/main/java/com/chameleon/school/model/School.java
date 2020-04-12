package com.chameleon.school.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class School {

	private UUID id;
	private int number;

	public School(UUID id, int number) {
		this.id = id;
		this.number = number;
	}

	public School(@JsonProperty("number") int number) {
		this(UUID.randomUUID(), number);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
