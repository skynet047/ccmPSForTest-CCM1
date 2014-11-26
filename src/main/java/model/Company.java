package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ACCM.dbo.COMPANY")
public class Company {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_company")
	private Integer id;

	@Column(name = "companyName")
	private String name;
	
	@Column(name = "divName")
	private String divisionName;
	
	@OneToMany(mappedBy = "company")
	private Collection<Consumer> listOfConsumers;
	
	@OneToMany(mappedBy = "company")
	private Collection<DataSource> listOfDataSource;
	
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
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public Collection<Consumer> getListOfConsumers() {
		return listOfConsumers;
	}
	public void setListOfConsumers(Collection<Consumer> listOfConsumers) {
		this.listOfConsumers = listOfConsumers;
	}
	public Collection<DataSource> getListOfDataSource() {
		return listOfDataSource;
	}
	public void setListOfDataSource(Collection<DataSource> listOfDataSource) {
		this.listOfDataSource = listOfDataSource;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", divisionName="
				+ divisionName + "]";
	}
	
	
	
}
