package model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ACCM.dbo.DISEASE")
public class Disease {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_disease")
	private Integer id;
	
	@Column(name = "disName")
	private String disName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ACCM.dbo.PRO_FOR_DIS", joinColumns = { 
			@JoinColumn(name = "id_disease") }, inverseJoinColumns = { @JoinColumn(name = "id_product") })
	private Collection <Product> listOfProducts;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listOfDisease")
	private Collection <Consumer> listOfConsumers;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ACCM.dbo.DIS_OF_MSPEC", joinColumns = { 
			@JoinColumn(name = "id_disease") }, inverseJoinColumns = { @JoinColumn(name = "id_mspec") })
	private Collection <MedicalSpecialization> listOfSpecializations;
	
	public Collection<Product> getListOfProducts() {
		return listOfProducts;
	}
	public void setListOfProducts(Collection<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDisName() {
		return disName;
	}
	public void setDisName(String disName) {
		this.disName = disName;
	}
	public Collection<Consumer> getListOfConsumers() {
		return listOfConsumers;
	}
	public void setListOfConsumers(Collection<Consumer> listOfConsumers) {
		this.listOfConsumers = listOfConsumers;
	}
	public Collection<MedicalSpecialization> getListOfSpecializations() {
		return listOfSpecializations;
	}
	public void setListOfSpecializations(
			Collection<MedicalSpecialization> listOfSpecializations) {
		this.listOfSpecializations = listOfSpecializations;
	}
	@Override
	public String toString() {
		return "Disease [id=" + id + ", disName=" + disName + "]";
	}	
	
}
