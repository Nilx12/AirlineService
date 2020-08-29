package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="class")
public class Class {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="meal")
	private boolean meal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMeal() {
		return meal;
	}

	public void setMeal(boolean meal) {
		this.meal = meal;
	}

	public Class() {

	}
	
	public Class(String name, boolean meal) {
		this.name = name;
		this.meal = meal;
	}
	
	
}
