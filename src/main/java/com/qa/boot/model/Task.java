package com.qa.boot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taskId;
	
	@NotNull
	private String name;
	
	@NotNull
	@Column(columnDefinition="Text")
	private String descript;
	@NotNull
	private Date dueDate;
	@NotNull
	private Date openDate;
	
	public Task(String name, String descript,Date openDate, Date dueDate) {
		this.setName(name);
		this.setDescript(descript);
		this.setDueDate(dueDate);
		this.setOpenDate(openDate);
	}
	
	public Task() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

}
