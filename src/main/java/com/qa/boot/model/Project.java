package com.qa.boot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;


public class Project extends Task {

	/*
	 * Before inserting date into MySQL change the format of date string to
	 * YYYY-MM-DD HH:mm:ss.
	 * 
	 * When you retrieve the date from database convert the date string from
	 * YYYY-MM-DD HH:mm:ss to your desired format.
	 */
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer projectId;

	@Column(columnDefinition = "Text")
	private String plan;

	@Column(columnDefinition = "Text")
	private String research;

	public Project(Integer projectId, String name, String descript, String plan, String research, Date openDate,
			Date dueDate) {
		super(name, descript, openDate, dueDate);

		this.setResearch(research);
		this.setPlan(plan);
		// TODO Auto-generated constructor stub
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getResearch() {
		return research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getProjectId() {
		return projectId;
	}
*/
}
