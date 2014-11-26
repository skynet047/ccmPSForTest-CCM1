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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ACCM.dbo.CONSUMER")
public class Consumer {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_consumer")
	private Integer id;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "isActiv")
	private char isActiv;
	
	@Column(name = "isAccepted")
	private char isAccepted;
	
	@ManyToOne
	@JoinColumn(name="id_owner")
	private Company company;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "usrType")
	private String userType;
	//private Adress adress;
	
	@Column(name = "phoneNo")
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name="id_source")
	private DataSource source;
	
	@Column(name = "comment")
	private String comment;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ACCM.dbo.CON_SPEC", joinColumns = { 
			@JoinColumn(name = "id_consumer") }, inverseJoinColumns = { @JoinColumn(name = "id_mspec") })
	private Collection<MedicalSpecialization> listOfSpecializations;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ACCM.dbo.CON_PRO", joinColumns = { 
			@JoinColumn(name = "id_consumer") }, inverseJoinColumns = { @JoinColumn(name = "id_product") })
	private Collection<Product> listOfProducts;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ACCM.dbo.CON_DIS", joinColumns = { 
			@JoinColumn(name = "id_consumer") }, inverseJoinColumns = { @JoinColumn(name = "id_disease") })
	private Collection<Disease> listOfDisease;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ACCM.dbo.CON_TER", joinColumns = { 
			@JoinColumn(name = "id_consumer") }, inverseJoinColumns = { @JoinColumn(name = "id_teraphy") })
	private Collection<Teraphy> listOfTeraphy;
	
	@OneToMany(mappedBy = "consumer")
	private Collection<Child> listOfChilds;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public char getIsActiv() {
		return isActiv;
	}
	public void setIsActiv(char isActiv) {
		this.isActiv = isActiv;
	}
	public char getIsAccepted() {
		return isAccepted;
	}
	public void setIsAccepted(char isAccepted) {
		this.isAccepted = isAccepted;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public DataSource getSource() {
		return source;
	}
	public void setSource(DataSource source) {
		this.source = source;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Collection<MedicalSpecialization> getListOfSpecializations() {
		return listOfSpecializations;
	}
	public void setListOfSpecializations(
			Collection<MedicalSpecialization> listOfSpecializations) {
		this.listOfSpecializations = listOfSpecializations;
	}
	public Collection<Product> getListOfProducts() {
		return listOfProducts;
	}
	public void setListOfProducts(Collection<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}
	public Collection<Disease> getListOfDisease() {
		return listOfDisease;
	}
	public void setListOfDisease(Collection<Disease> listOfDisease) {
		this.listOfDisease = listOfDisease;
	}
	public Collection<Teraphy> getListOfTeraphy() {
		return listOfTeraphy;
	}
	public void setListOfTeraphy(Collection<Teraphy> listOfTeraphy) {
		this.listOfTeraphy = listOfTeraphy;
	}
	public Collection<Child> getListOfChilds() {
		return listOfChilds;
	}
	public void setListOfChilds(Collection<Child> listOfChilds) {
		this.listOfChilds = listOfChilds;
	}
	@Override
	public String toString() {
		return "Consumer [id=" + id + ", mail=" + mail + ", isActiv=" + isActiv
				+ ", isAccepted=" + isAccepted + ", company=" + company
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", sex=" + sex + ", userType=" + userType + ", phoneNumber="
				+ phoneNumber + ", source=" + source + ", comment=" + comment
				+ ", listOfSpecializations=" + listOfSpecializations
				+ ", listOfProducts=" + listOfProducts + ", listOfDisease="
				+ listOfDisease + ", listOfTeraphy=" + listOfTeraphy
				+ ", listOfChilds=" + listOfChilds + "]";
	}
	
	
	
}
