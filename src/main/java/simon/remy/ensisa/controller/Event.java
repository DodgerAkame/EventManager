package simon.remy.ensisa.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity(name="events")
@Table(name="events")
public class Event {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@NotNull
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="date")
	private String date;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Min(1)
	@Column(name="hours")
	private int hours;
	
	@Column(name="lieu")
	private String lieu;
	
	@Column(name="type")
	private String type;

	public Event() {

	}

	public Event(String date, String title, String description, int hours, String location, String type) {
		this.date = date;
		this.description = description;
		this.hours = hours;
		this.lieu = location;
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String location) {
		this.lieu = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
