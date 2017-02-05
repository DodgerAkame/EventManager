package simon.remy.ensisa.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="events")
public class Event {

	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	@DateTimeFormat(iso=ISO.DATE)
	private String date;
	private String title;
	private String description;
	@Min(1)
	private int hours;
	private String lieu;
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
