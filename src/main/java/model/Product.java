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
@Table(name="ACCM.dbo.PRODUCT")
public class Product{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_product")
	private Integer id;
	
	@Column(name = "nameOfPro")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listOfProducts")
	private Collection <Disease> listOfDisease;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listOfProducts")
	private Collection <Consumer> listOfConsumers;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ACCM.dbo.TER_OF_PRO", joinColumns = { 
			@JoinColumn(name = "id_product") }, inverseJoinColumns = { @JoinColumn(name = "id_teraphy") })
	private Collection<Teraphy> listOfTeraphy;
	
	public Product(){
		
	}
	
	
	public Product(Integer id_pro, String nameOfPro) {
		super();
		this.id = id_pro;
		this.name = nameOfPro;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String nameOfPro) {
		this.name = nameOfPro;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id_prod) {
		this.id = id_prod;
	}

	public Collection<Disease> getListOfDisease() {
		return listOfDisease;
	}

	public void setListOfDisease(Collection<Disease> listOfDisease) {
		this.listOfDisease = listOfDisease;
	}

	
	
	public Collection<Consumer> getListOfConsumers() {
		return listOfConsumers;
	}

	public void setListOfConsumers(Collection<Consumer> listOfConsumers) {
		this.listOfConsumers = listOfConsumers;
	}


	public Collection<Teraphy> getListOfTeraphy() {
		return listOfTeraphy;
	}


	public void setListOfTeraphy(Collection<Teraphy> listOfTeraphy) {
		this.listOfTeraphy = listOfTeraphy;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", listOfDisease="
				+ listOfDisease + "]";
	}
	
}
