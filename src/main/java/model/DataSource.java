package model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ACCM.dbo.SOUR_OF_DATA")
public class DataSource {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_source")
	private Integer id;
	
	@Column(name = "actionTitle")
	private String actionTitle;
	
	@Column(name = "aDate")
	private Date aDate;
	
	@ManyToOne
	@JoinColumn(name="id_company")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="id_person")
	private Person person;
	
	@Column(name = "turn")
	private Integer turn;
	
	@Column(name = "typeOfAction")
	private String typeOfAction;
	
	@OneToMany(mappedBy = "source")
	private Collection<Consumer> listOfConsumers;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getActionTitle() {
		return actionTitle;
	}
	public void setActionTitle(String actionTitle) {
		this.actionTitle = actionTitle;
	}
	public Date getaDate() {
		return aDate;
	}
	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Integer getTurn() {
		return turn;
	}
	public void setTurn(Integer turn) {
		this.turn = turn;
	}
	public String getTypeOfAction() {
		return typeOfAction;
	}
	public void setTypeOfAction(String typeOfAction) {
		this.typeOfAction = typeOfAction;
	}
	public Collection<Consumer> getListOfConsumers() {
		return listOfConsumers;
	}
	public void setListOfConsumers(Collection<Consumer> listOfConsumers) {
		this.listOfConsumers = listOfConsumers;
	}
	@Override
	public String toString() {
		return "DataSource [id=" + id + ", actionTitle=" + actionTitle
				+ ", aDate=" + aDate + ", company=" + company + ", person="
				+ person + ", turn=" + turn + ", typeOfAction=" + typeOfAction
				+ "]";
	}
	

	
}
