package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ACCM.dbo.MSPEC")
public class MedicalSpecialization {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_mspec")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listOfSpecializations")
	private Collection <Consumer> listOfConsumers;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listOfSpecializations")
	private Collection <Disease> listOfDisease;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Consumer> getListOfConsumers() {
		return listOfConsumers;
	}
	public void setListOfConsumers(Collection<Consumer> listOfConsumers) {
		this.listOfConsumers = listOfConsumers;
	}
	public Collection<Disease> getListOfDisease() {
		return listOfDisease;
	}
	public void setListOfDisease(Collection<Disease> listOfDisease) {
		this.listOfDisease = listOfDisease;
	}
	@Override
	public String toString() {
		return "MedicalSpecialization [id=" + id + ", name=" + name + "]";
	}
	

}
