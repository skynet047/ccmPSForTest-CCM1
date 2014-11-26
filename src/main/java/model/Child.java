package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCM.dbo.CHILD")
public class Child {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_consumer")
	private Integer id;
	
	@Column(name = "dateOfB")
	private Date dateOfBirth;
	
	@Column(name = "nameOfChild")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="id_consumer", insertable = false, updatable = false)
	private Consumer consumer;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	@Override
	public String toString() {
		return "Child [id=" + id + ", dateOfBirth=" + dateOfBirth + ", name="
				+ name + "]";
	}
	
	
}
