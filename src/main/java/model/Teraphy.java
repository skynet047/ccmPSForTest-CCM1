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
@Table(name="ACCM.dbo.TERAPHY")
public class Teraphy {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_teraphy")
	private Integer id;
	
	@Column(name = "theraphyName")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listOfTeraphy")
	private Collection <Consumer> listOfConsumers;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listOfTeraphy")
	private Collection <Product> listOfProducts;
	
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
	public Collection<Product> getListOfProducts() {
		return listOfProducts;
	}
	public void setListOfProducts(Collection<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}
	@Override
	public String toString() {
		return "Teraphy [id=" + id + ", name=" + name + "]";
	}
	
	
}
