package simon.remy.ensisa.controller;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity(name = "events")
@Table(name = "events")
@Access(value = AccessType.FIELD)
@DynamicUpdate
public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "date")
	private String date;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Min(1)
	@Column(name = "hours")
	private int hours;

	@Column(name = "lieu")
	private String lieu;

	@Column(name = "type")
	private String type;
	
	@Column(name = "favorite")
	private boolean favorite;

	public Event() {

	}

	public Event(String date, String title, String description, int hours, String location, String type) {
		this.date = date;
		this.title = title;
		this.description = description;
		this.hours = hours;
		this.lieu = location;
		this.type = type;
		this.favorite = false;
	}

	// TODO faire une méthode PostConstruc ini pour remplir la base

	
	
	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "[Event :: Title :" + title + "; Description :" + description + "; Date : " + date + "; Hours : " + hours
				+ "; Lieu : " + lieu + "; Type : " + type + "; ID : " + id + "]";
	}

}
